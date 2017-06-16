package br.com.hubfintech.controlecontas.controller.dto;


/**
 * Classe que representa uma solicitação de estorno de uma transferencia ou aporte
 * @author Eric
 *
 */
public class EstornoRequest extends Request {
	
	/**  identificados da transacao que esta sendo solicitado o estorno */
	private String codigoAporte;
	
	/** valor do estorno */
	private String valor;

	/**
	 * @return the codigoAporte
	 */
	public String getCodigoAporte() {
		return codigoAporte;
	}

	/**
	 * @param codigoAporte the codigoAporte to set
	 */
	public void setCodigoAporte(String transacaoId) {
		this.codigoAporte = transacaoId;
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
