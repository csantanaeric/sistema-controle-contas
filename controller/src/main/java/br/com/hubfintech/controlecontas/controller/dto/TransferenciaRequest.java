/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.dto;

/**
 * Classe que representa uma solicitação de  tranferencia entre contas
 * @author Eric
 *
 */
public class TransferenciaRequest extends Request {
	
	/**
	 * the conta em que sera subtraido o valor da tranferencia
	 */
	private String contaOrigem;
	
	/**
	 * conta em que o valor sera acrescido
	 */
	private String contaDestino;
	
	/**
	 * the valor da tranferencia
	 */
	private String valor;

	/**
	 * @return the contaOrigem
	 */
	public String getContaOrigem() {
		return contaOrigem;
	}

	/**
	 * @param contaOrigem the contaOrigem to set
	 */
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	/**
	 * @return the contaDestino
	 */
	public String getContaDestino() {
		return contaDestino;
	}

	/**
	 * @param contaDestino the contaDestino to set
	 */
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
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
