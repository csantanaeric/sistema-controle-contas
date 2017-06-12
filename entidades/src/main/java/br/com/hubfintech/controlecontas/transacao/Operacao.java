/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import java.util.Date;

/**
 * Classe que representa um operacao
 * @author Eric
 *
 */
public abstract class Operacao {
	
	/** valor da operacao */
	private double valor;
	
	/** data da operacao */
	private Date dataOpercao;
	
	/** Status da operacao  */
	private StatusOperacao status;

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the status
	 */
	public StatusOperacao getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusOperacao status) {
		this.status = status;
	}

}
