/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

/**
 * @author Eric
 *
 */
public class Transacao {
	
	/** Indentificado unico da transacao  */
	private String transacaoId;
	
	/** operacao da transacao  */
	private Operacao operacao;
	
	/** operacao de estorno  */
	private Estorno estorno;

	/**
	 * @return the transacaoId
	 */
	public String getTransacaoId() {
		return transacaoId;
	}

	/**
	 * @param transacaoId the transacaoId to set
	 */
	public void setTransacaoId(String transacaoId) {
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
	
}

