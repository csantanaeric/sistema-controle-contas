/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.impl.RegrasDeAporte;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio do aporte
 * @author Eric
 *
 */
@Service
public class AporteService implements OperacaoService {
	
	@Autowired
	private RegrasDeAporte regrasDeAporte;


	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) throws RegrasNegocioException {
		try {
			regrasDeAporte.validar(transacao);
		} catch (RegrasNegocioException e) {
			throw e;
		}
		
		regrasDeAporte.executarOperacao(transacao);

		return transacao;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof AporteRequest; 
	}

}
