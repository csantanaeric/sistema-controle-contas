package br.com.hubfintech.controlecontas.transacao;

public enum StatusOperacao {
	
	EXECUTANDO("E"),APROVADO("A"),NEGADO("N");
	
	private String codigoSatus;

	private StatusOperacao(String codigoSatus) {
		this.setCodigoSatus(codigoSatus);
	}

	/**
	 * @return the codigoSatus
	 */
	public String getCodigoSatus() {
		return codigoSatus;
	}

	/**
	 * @param codigoSatus the codigoSatus to set
	 */
	public void setCodigoSatus(String codigoSatus) {
		this.codigoSatus = codigoSatus;
	}
	
}
