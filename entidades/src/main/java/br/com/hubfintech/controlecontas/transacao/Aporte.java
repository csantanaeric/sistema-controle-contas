/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import br.com.hubfintech.controlecontas.contas.ContaMatriz;

/**
 * Classe que representa um Aporte
 * @author Eric
 *
 */
public class Aporte extends Operacao {
	
	/** Conta que em que sera creditado o valor da operacao */
	private ContaMatriz conta;

	/**
	 * @return the conta
	 */
	public ContaMatriz getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(ContaMatriz conta) {
		this.conta = conta;
	}

}
