/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import java.util.Date;

/**
 * Classe que representa um operacao
 * @author Eric
 *
 */
public abstract class Operacao {
	
	/** valor da operacao */
	private double valor;
	
	/** data da operacao */
	private Date dataOpercao;
	
	/** Status da operacao  */
	private StatusOperacao status;
	
	/** Tipo operacao  */
	private TipoOperacao tipoOpercao;

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

	@Override
	public String toString() {
		return "Operacao [valor=" + valor + ", dataOpercao=" + dataOpercao + ", status=" + status + "]";
	}

	/**
	 * @return the tipoOpercao
	 */
	public TipoOperacao getTipoOpercao() {
		return tipoOpercao;
	}

	/**
	 * @param tipoOpercao the tipoOpercao to set
	 */
	public void setTipoOpercao(TipoOperacao tipoOpercao) {
		this.tipoOpercao = tipoOpercao;
	}
	
}
