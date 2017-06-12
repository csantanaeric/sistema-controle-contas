/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * @author Eric
 *
 */
@Component
public class RegrasDeTransferencia implements RegrasTransacao {

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao#validar(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public void validar(Transacao transacao) throws RegrasNegocioException {
		Transferencia tranferencia = (Transferencia)transacao.getOperacao();
		 


	}

}
