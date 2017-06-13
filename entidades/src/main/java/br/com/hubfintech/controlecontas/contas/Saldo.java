/**
 * 
 */
package br.com.hubfintech.controlecontas.contas;

import java.util.Date;

/**
 * @author eric
 *
 */
public class Saldo {
	
	private Long id;
	
	private Long contaId;
	
	private Double valor;
	
	private Date dataAtualizacao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the contaId
	 */
	public Long getContaId() {
		return contaId;
	}

	/**
	 * @param contaId the contaId to set
	 */
	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	/**
	 * @return the dataAtualizacao
	 */
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Saldo [id=" + id + ", contaId=" + contaId + ", valor=" + valor + ", dataAtualizacao=" + dataAtualizacao
				+ "]";
	}
	
}
