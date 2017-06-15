/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

/**
 * Classe que representa um Aporte
 * @author Eric
 *
 */
public class Aporte extends Operacao {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aporte [getValor()=" + getValor() + ", getStatus()=" + getStatus() + ", getDataOpercao()="
				+ getDataOpercao() + ", getTipoOpercao()=" + getTipoOpercao() + ", getCodigoAporte()="
				+ getCodigoAporte() + ", getContaOrigem()=" + getContaOrigem() + ", getContaDestino()="
				+ getContaDestino() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
