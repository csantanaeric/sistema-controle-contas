package br.com.hubfintech.controlecontas.controller.dto;

/**
 * Classe que representa uma solicitação de aporte
 * @author Eric
 *
 */
public class AporteRequest extends Request {
	
	/** conta de destino que recebera o valor */
	private String contaBeneficiada;
	
	/** valor do aporte  */
	private String valor;

	/**
	 * @return the contaBeneficiada
	 */
	public String getContaBeneficiada() {
		return contaBeneficiada;
	}

	/**
	 * @param contaBeneficiada the contaBeneficiada to set
	 */
	public void setContaBeneficiada(String contaBeneficiada) {
		this.contaBeneficiada = contaBeneficiada;
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
