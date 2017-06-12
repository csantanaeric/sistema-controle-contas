/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio do aporte
 * @author Eric
 *
 */
@Service
public class AporteService implements OperacaoService {

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) {
		return null;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof AporteRequest; 
	}

}
