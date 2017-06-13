/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.regras;

import br.com.hubfintech.controlecontas.transacao.Operacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * @author eric
 *
 */
@FunctionalInterface
public interface Regra {
	
	String executar(Transacao transacao, Operacao operacao);

}
