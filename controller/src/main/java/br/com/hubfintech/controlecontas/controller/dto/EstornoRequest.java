package br.com.hubfintech.controlecontas.controller.dto;


/**
 * Classe que representa uma solicitação de estorno de uma transferencia ou aporte
 * @author Eric
 *
 */
public class EstornoRequest extends Request {
	
	/**  identificados da transacao que esta sendo solicitado o estorno */
	private String transacaoId;
	
	/** valor do estorno */
	private String valor;

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
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
