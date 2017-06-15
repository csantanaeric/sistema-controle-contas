/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.contas.StatusConta;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.utils.ContasUtils;

/**
 * Classe que encapsula as regras de validação e execuçãodo do aporte
 * @author Eric
 *
 */
@Component
public class RegrasDeAporte implements RegrasTransacao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegrasDeAporte.class);
	
	@Autowired
	private OperacaoDao operacaoDao;
	
	@Autowired
	private TransacaoDao transacaoDao;
	
	@Autowired
	private SaldoDao saldoDao;

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#validar(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void validar(Transacao transacao) throws RegrasNegocioException {
		if(transacao.getOperacao() != null && transacao.getOperacao() instanceof Aporte){
			Aporte aporte = (Aporte) transacao.getOperacao();
			if(aporte.getContaDestino() == null){
				throw new RegrasNegocioException("Operacao não realizada. Conta não informada!");
			}
			if(!StatusConta.ATIVA.equals(aporte.getContaDestino().getStatusConta())){
				throw new RegrasNegocioException("Operacao não permitida. A conta está ativa!");
			}
			if(aporte.getContaDestino().getContaPaiMatriz() != null ){
				throw new RegrasNegocioException("Operacao não permitida. A conta de destino não é uma conta matriz!");
			}
			if(aporte.getValor() <= 0){
				throw new RegrasNegocioException("Operacao não realizada. Valor de aporte inválido!");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#executarOperacao(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void executarOperacao(Transacao transacao) throws RegrasNegocioException {
		Aporte aporte = (Aporte) transacao.getOperacao();
		long transacaoId =  transacaoDao.inserirTransacao(transacao);
		try {
			aporte.setCodigoAporte(this.gerarAporteId(transacaoId));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Falha ao gerar id do aporte.",e);
			throw new RuntimeException(e);
		}
		Conta conta = aporte.getContaDestino();
		Saldo saldo = ContasUtils.getSaldo(conta.getSaldos());
		Saldo novoSaldo = new Saldo();
		novoSaldo.setContaId(conta.getId());
		novoSaldo.setDataAtualizacao(new Date());
		novoSaldo.setValor(saldo.getValor()+aporte.getValor());
		saldoDao.inserir(saldo);
		operacaoDao.inserirOperacao(transacao, aporte);
	}

	/**
	 * Algoritimo para gerar um identificador único para o aporte
	 * @param transacaoid
	 * @return id unico
	 * @throws NoSuchAlgorithmException
	 */
	private String gerarAporteId(long transacaoid) throws NoSuchAlgorithmException {
		String id = Long.toString(new Date().getTime())+transacaoid;
		return new String(Hex.encodeHex(MessageDigest.getInstance("MD5").digest(id.getBytes())));
	}
}
