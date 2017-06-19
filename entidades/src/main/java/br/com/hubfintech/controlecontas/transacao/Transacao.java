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
	
	/** Identificador unico do aporte */
	private String codigoAporte;
	
	/** data da transacao  */
	private Date data;
	
	public Transacao() {}

	public Transacao(Long transacaoId, Operacao operacao, Estorno estorno, String codigoAporte, Date data) {
		this.transacaoId = transacaoId;
		this.operacao = operacao;
		this.estorno = estorno;
		this.codigoAporte = codigoAporte;
		this.data = data;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transacao [transacaoId=" + transacaoId + ", operacao=" + operacao + ", estorno=" + estorno
				+ ", codigoAporte=" + codigoAporte + ", data=" + data + "]";
	}
	
}
