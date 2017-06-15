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
	
	/** valor da operacao */
	private double valor;
	
	/** data da operacao */
	private Date dataOpercao;
	
	/** Status da operacao  */
	private StatusOperacao status;
	
	/** Tipo operacao  */
	private TipoOperacao tipoOpercao;

	/** Identificador unico do aporte */
	private String codigoAporte;
	
	/** Conta que sera debitado o valor da operacao */
	private Conta contaOrigem;
	
	/** Conta que sera creditado o valor da operacao */
	private Conta contaDestino;
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operacao [valor=" + valor + ", dataOpercao=" + dataOpercao + ", status=" + status + ", tipoOpercao="
				+ tipoOpercao + ", codigoAporte=" + codigoAporte + ", contaOrigem=" + contaOrigem + ", contaDestino="
				+ contaDestino + "]";
	}
	
}
