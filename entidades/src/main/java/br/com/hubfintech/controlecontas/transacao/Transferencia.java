/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * Operacao de Tranferencia
 * @author Eric
 *
 */
public class Transferencia extends Operacao {
	
	/** Conta que sera debitado o valor da operacao */
	private Conta contaOrigem;
	
	/** Conta que sera creditado o valor da operacao */
	private Conta contaDestino;

	/**
	 * @return the contaOrigem
	 */
	public Conta getContaOrigem() {
		return contaOrigem;
	}

	/**
	 * @param contaOrigem the contaOrigem to set
	 */
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	/**
	 * @return the contaDestino
	 */
	public Conta getContaDestino() {
		return contaDestino;
	}

	/**
	 * @param contaDestino the contaDestino to set
	 */
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}


	
}
