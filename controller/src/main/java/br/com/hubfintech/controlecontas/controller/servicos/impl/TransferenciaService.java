/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.impl.RegrasDeTransferencia;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio da operacao de tranferencia
 * @author Eric
 *
 */
@Service
public class TransferenciaService implements OperacaoService {
	
	@Autowired
	@Qualifier("regrasDeTransferencia")
	private RegrasDeTransferencia regra;
	
	@Autowired
	private TransacaoDao transacaoDao;
	
	@Autowired
	private SaldoDao saldoDao;

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) throws RegrasNegocioException {
		try {
			regra.validar(transacao);
		} catch (RegrasNegocioException e) {
			throw e;
		}
		regra.executarOperacao(transacao);
		
		transacaoDao.inserirTransacao(transacao);
		
		return transacao;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof TransferenciaRequest;
	}

}
