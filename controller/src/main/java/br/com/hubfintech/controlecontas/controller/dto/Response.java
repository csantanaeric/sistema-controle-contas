package br.com.hubfintech.controlecontas.controller.dto;

/**
 * Classe que representa a respostas dos serviços disponibilizados.	
 * @author Eric
 *
 */
public class Response {
	
	/** status da operacao */
	private String status;
	
	/** mensagem de retorno */
	private String mensagem;
	
	/** valor da operacao */
	private String valor;
	
	/** codigo do aporte */
	private String codigoAporte;
	
	/** codigo da transacao */
	private Long cdTransacao;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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

	/**
	 * @return the cdTransacao
	 */
	public Long getCdTransacao() {
		return cdTransacao;
	}

	/**
	 * @param cdTransacao the cdTransacao to set
	 */
	public void setCdTransacao(Long cdTransacao) {
		this.cdTransacao = cdTransacao;
	}

}
