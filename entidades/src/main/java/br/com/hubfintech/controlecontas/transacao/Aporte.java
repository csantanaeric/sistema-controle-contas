/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * Classe que representa um Aporte
 * @author Eric
 *
 */
public class Aporte extends Operacao {

	/** Conta em que sera creditado o valor da operacao */
	private Conta conta;
	
	/** Identificador unico do aporte */
	private String codigoAporte;

	/**
	 * @return the conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Aporte [conta=" + conta + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return the codigoAporte
	 */
	public String getCodigoAporte() {
		return codigoAporte;
	}

	/**
	 * @param codigoAporte the codigoAporte to set
	 */
	public void setCodigoAporte(String codigoAporte) {
		this.codigoAporte = codigoAporte;
	}

}
