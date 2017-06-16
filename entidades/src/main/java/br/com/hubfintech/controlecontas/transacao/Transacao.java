/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import java.util.Date;

/**
 * @author Eric
 *
 */
public class Transacao {
	
	/** Id da transacao  */
	private Long transacaoId;
	
	/** operacao da transacao  */
	private Operacao operacao;
	
	/** operacao de estorno  */
	private Estorno estorno;
	
	/** data da transacao  */
	private Date data;

	/**
	 * @return the transacaoId
	 */
	public Long getTransacaoId() {
		return transacaoId;
	}

	/**
	 * @param transacaoId the transacaoId to set
	 */
	public void setTransacaoId(Long transacaoId) {
		this.transacaoId = transacaoId;
	}

		/**
	 * @return the estorno
	 */
	public Estorno getEstorno() {
		return estorno;
	}

	/**
	 * @param estorno the estorno to set
	 */
	public void setEstorno(Estorno estorno) {
		this.estorno = estorno;
	}

	/**
	 * @return the operacao
	 */
	public Operacao getOperacao() {
		return operacao;
	}

	/**
	 * @param operacao the operacao to set
	 */
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transacao [transacaoId=" + transacaoId + ", operacao=" + operacao + ", estorno=" + estorno + ", data="
				+ data + "]";
	}
	
}
