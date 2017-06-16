/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.contas.StatusConta;
import br.com.hubfintech.controlecontas.controller.regras.Regra;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;
import br.com.hubfintech.utils.ContasUtils;

/**
 * Classe que encapsula as regras de validação e execuçãodo de tranferencia
 * @author Eric
 *
 */
@Component
public class RegrasDeTransferencia implements RegrasTransacao {
	
	
	@Autowired
	private SaldoDao saldoDao;
	
	@Autowired
	TransacaoDao transacaoDao;

	@Autowired
	private OperacaoDao operacaoDao;
	
	private List<Regra> listaRegras;

	/**to-do subistituir os ifs por lambda*/
	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#validar(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void validar(Transacao transacao) throws RegrasNegocioException {
		Transferencia transferencia = (Transferencia)transacao.getOperacao();
		try {
			if(transferencia.getValor() <= 0 ){
				throw new  RegrasNegocioException("Operação não realizada. Valor inválido.");
			}
			
			if(transferencia.getContaOrigem() == null || transferencia.getContaDestino() == null ){
				throw new  RegrasNegocioException("Operação não realizada. Conta de origem ou destino não informado.");
			}
			
			if(!StatusConta.ATIVA.equals(transferencia.getContaDestino().getStatusConta())){
				throw new RegrasNegocioException("Operacao não permitida. A conta não está ativa!");
			}
			
			Saldo saldo = ContasUtils.getSaldo(transferencia.getContaOrigem().getSaldos()); 
			
			if( saldo.getValor() < transferencia.getValor()){
				throw new  RegrasNegocioException("Operação não realizada. Saldo insuficiente.");
			}
			
			if(transferencia.getContaDestino().getContaPaiMatriz() == null){
				throw new  RegrasNegocioException("Operação não permitida. A conta de destino é uma conta Matriz.");
			}
			
			if(transferencia.getContaOrigem().getContaPaiMatriz().getId() != transferencia.getContaDestino().getContaPaiMatriz().getId()){
				throw new  RegrasNegocioException("Operação não permitida. As contas de origiem e destino não descendem da mesma conta matriz.");
			}
		} catch (RegrasNegocioException e) {
			transferencia.setStatus(StatusOperacao.NEGADO);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#executarOperacao(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void executarOperacao(Transacao transacao) throws RegrasNegocioException {
		Transferencia transferencia = (Transferencia) transacao.getOperacao();
		transferencia.setDataOpercao(new Date());
		Saldo saldoOrigem = new Saldo();
		saldoOrigem.setContaId(transferencia.getContaOrigem().getId());
		saldoOrigem.setDataAtualizacao(new Date());
		saldoOrigem.setValor(ContasUtils.getSaldo(transferencia.getContaOrigem().getSaldos()).getValor() - transferencia.getValor());
		transferencia.getContaOrigem().getSaldos().add(0, saldoOrigem);
		Saldo saldoDestino = new Saldo();
		saldoDestino.setContaId(transferencia.getContaOrigem().getId());
		saldoDestino.setDataAtualizacao(new Date());
		saldoDestino.setValor(ContasUtils.getSaldo(transferencia.getContaOrigem().getSaldos()).getValor() + transferencia.getValor());
		transferencia.getContaDestino().getSaldos().add(0,saldoDestino);
		saldoDao.inserir(saldoOrigem,saldoDestino);
		Long transacaoId = transacaoDao.inserirTransacao(transacao);
		transacao.setTransacaoId(transacaoId);
		operacaoDao.inserirOperacao(transacao, transferencia);
	}

}
