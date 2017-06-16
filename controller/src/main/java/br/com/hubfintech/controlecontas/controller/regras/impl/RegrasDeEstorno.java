/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;
import br.com.hubfintech.utils.ContasUtils;

/**
 * Classe que encapsula as regras de validação e execuçãodo do estorno
 * @author Eric
 *
 */
@Component
public class RegrasDeEstorno implements RegrasTransacao {

	@Autowired
	private OperacaoDao operacaoDao;
	
	@Autowired
	private SaldoDao saldoDao;
	
	@Autowired
	private TransacaoDao transacaoDao;
	
	Conta conta = null;
	Conta contaOrigem = null;
	Estorno estorno = null;
	Aporte aporte = null;
	Transferencia transferencia = null;
	Saldo saldoAnterior = null;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#validar(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void validar(Transacao transacao) throws RegrasNegocioException {
		estorno = transacao.getEstorno();
		
		if(transacao.getOperacao() == null){
			throw new RegrasNegocioException("Transação não encontrada para estorno.");
		}
		
		if(transacao.getOperacao() instanceof Aporte){
			aporte =  (Aporte) transacao.getOperacao();
			if(transacao.getCodigoAporte() == null){
				throw new RegrasNegocioException("Operação não permitida. Codigo aporte não informado.");
			}
			conta = aporte.getContaDestino();
		} else if(transacao.getOperacao() instanceof Transferencia){
			transferencia = (Transferencia) transacao.getOperacao();
			conta = transferencia.getContaDestino();
			contaOrigem = transferencia.getContaOrigem();
		}
		saldoAnterior = ContasUtils.getSaldo(conta.getSaldos());
		if(estorno.getValor() > saldoAnterior.getValor() ){
			throw new RegrasNegocioException("Operação não permitida. Saldo insuficiente.");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#executarOperacao(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void executarOperacao(Transacao transacao) throws RegrasNegocioException {
		this.validar(transacao);
		Saldo saldo = new Saldo();
		saldo.setContaId(this.conta.getId());
		saldo.setDataAtualizacao(new Date());
		saldo.setValor(saldoAnterior.getValor()-estorno.getValor());
		Saldo saldoContaOrigem = null;
		if(contaOrigem != null){
			saldoContaOrigem = new Saldo();
			saldoContaOrigem.setContaId(this.conta.getId());
			saldoContaOrigem.setDataAtualizacao(new Date());
			saldoContaOrigem.setValor(ContasUtils.getSaldo(contaOrigem.getSaldos()).getValor() +estorno.getValor());
		}
		
		saldoDao.inserir(saldo,saldoContaOrigem);
		
		operacaoDao.inserirOperacao(transacao, estorno);
		
		transacaoDao.inserirTransacao(transacao);
	}

}
