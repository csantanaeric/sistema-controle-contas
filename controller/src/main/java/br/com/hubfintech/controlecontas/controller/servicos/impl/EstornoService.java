/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio da operacao estorno
 * @author Eric
 *
 */
@Service
public class EstornoService implements OperacaoService {

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof EstornoRequest;
	}

}
