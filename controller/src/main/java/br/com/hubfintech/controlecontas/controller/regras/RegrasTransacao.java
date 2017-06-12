/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras;

import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Responsavel por validar a transacao com as regras de negocio
 * @author Eric
 *
 */
public interface RegrasTransacao {
	
	
	/**
	 * Validar as regras de negocio
	 * @param transacao
	 * @throws RegrasNegocioException
	 */
	public void validar(Transacao transacao) throws RegrasNegocioException;

}
