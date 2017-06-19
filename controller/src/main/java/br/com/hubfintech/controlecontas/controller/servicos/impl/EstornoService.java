/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.impl.RegrasDeEstorno;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio da operacao estorno
 * @author Eric
 *
 */
@Service("estornoService")
public class EstornoService implements OperacaoService {
	
	@Autowired
	private RegrasDeEstorno regrasDeEstorno;
	

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) throws RegrasNegocioException {
		try {
			regrasDeEstorno.executarOperacao(transacao);
		} catch (RegrasNegocioException e) {
			throw e;
		}
		return transacao;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof EstornoRequest;
	}

}
