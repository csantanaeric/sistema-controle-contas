package br.com.hubfintech.controlecontas.controller.dto;

/**
 * Classe abstrata que representa um requisição aos serviços disponibilizados.	 
 * @author Eric
 */
public abstract class Request {
	
	/**
	 * Retorno da requisicao
	 */
	private Response response;

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Response response) {
		this.response = response;
	}

}
