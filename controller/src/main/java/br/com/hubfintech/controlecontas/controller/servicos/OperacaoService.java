/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Representa as execuçao das regras de negocio
 * @author Eric
 *
 */
public interface OperacaoService {
	
	/**
	 * Executa as regras de negocio
	 * @param transacao
	 * @return the transacao processada
	 * @throws RegrasNegocioException 
	 */
	public Transacao execute(Transacao transacao) throws RegrasNegocioException;
	
	
	/**
	 * Usado para selecionar o servico equivalente a requisicao
	 * @param request
	 * @return verdadeiro se o servico deve ser executado
	 */
	public boolean isOperacaoCorrente(Request request);

}
