/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras.impl;

import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * @author Eric
 *
 */
@Component
public class RegrasDeEstorno implements RegrasTransacao {

	@Override
	public void validar(Transacao transacao) throws RegrasNegocioException {
		Estorno estorno = transacao.getEstorno();
		if(transacao.getOperacao() == null){
			throw new RegrasNegocioException("Transação não encontrada para estorno.");
		}
		
		
	}

	@Override
	public void executarOperacao(Transacao transacao) throws RegrasNegocioException {
		
		
	}

}
