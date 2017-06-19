/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import java.util.Date;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * Classe que representa um operacao
 * @author Eric
 *
 */
public abstract class Operacao {
	
	/** id da operacao */
	private Long id;
	
	/** valor da operacao */
	private double valor;
	
	/** data da operacao */
	private Date dataOpercao;
	
	/** Status da operacao  */
	private StatusOperacao status;
	
	/** Tipo operacao  */
	private TipoOperacao tipoOperacao;

	/** Conta que sera debitado o valor da operacao */
	private Conta contaOrigem;
	
	/** Conta que sera creditado o valor da operacao */
	private Conta contaDestino;
	
	public Operacao(){}
	
	
	/**
	 * Construtor utilizado nos teste unitarios.
	 * @param id
	 * @param valor
	 * @param dataOpercao
	 * @param status
	 * @param tipoOperacao
	 * @param contaOrigem
	 * @param contaDestino
	 */
	public Operacao(Long id, double valor, Date dataOpercao, StatusOperacao status, TipoOperacao tipoOperacao,
			Conta contaOrigem, Conta contaDestino) {
		this.id = id;
		this.valor = valor;
		this.dataOpercao = dataOpercao;
		this.status = status;
		this.tipoOperacao = tipoOperacao;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
	}



	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the status
	 */
	public StatusOperacao getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusOperacao status) {
		this.status = status;
	}

	/**
	 * @return the dataOpercao
	 */
	public Date getDataOpercao() {
		return dataOpercao;
	}

	/**
	 * @param dataOpercao the dataOpercao to set
	 */
	public void setDataOpercao(Date dataOpercao) {
		this.dataOpercao = dataOpercao;
	}

	/**
	 * @return the tipoOperacao
	 */
	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	/**
	 * @param tipoOperacao the tipoOperacao to set
	 */
	public void setTipoOperacao(TipoOperacao tipoOpercao) {
		this.tipoOperacao = tipoOpercao;
	}

	/**
	 * @return the contaOrigem
	 */
	public Conta getContaOrigem() {
		return contaOrigem;
	}

	/**
	 * @param contaOrigem the contaOrigem to set
	 */
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	/**
	 * @return the contaDestino
	 */
	public Conta getContaDestino() {
		return contaDestino;
	}

	/**
	 * @param contaDestino the contaDestino to set
	 */
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operacao [id=" + id + ", valor=" + valor + ", dataOpercao=" + dataOpercao + ", status=" + status
				+ ", tipoOperacao=" + tipoOperacao + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino
				+ ", toString()=" + super.toString() + "]";
	}

}
