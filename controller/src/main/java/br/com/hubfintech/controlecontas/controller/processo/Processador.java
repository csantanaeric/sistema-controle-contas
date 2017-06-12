/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.processo;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.processo.impl.RetornoService;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Responsavel por executar os servicos
 * @author Eric
 *
 */
public interface Processador {
	
	/**
	 * Seleciona o servico adequado e executa.
	 * @param request
	 * @return
	 */
	void execute(Request request, RetornoService retorno);

}
