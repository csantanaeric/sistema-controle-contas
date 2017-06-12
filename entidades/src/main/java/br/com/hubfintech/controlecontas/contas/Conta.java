/**
 * 
 */
package br.com.hubfintech.controlecontas.contas;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa abstração de uma conta
 * @author Eric
 *
 */
public abstract class Conta {

	/** the nome da conta */
	private String nome;
	
	/** the data de criação da conta */
	private Date dataCriacao;
	
	/** the Saldo da conta */
	private Double saldo;
	
	/** the lista de contas filhas */
	private List<Conta> contasFilhas;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the contasFilhas
	 */
	public List<Conta> getContasFilhas() {
		return contasFilhas;
	}

	/**
	 * @param contasFilhas the contasFilhas to set
	 */
	public void setContasFilhas(List<Conta> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}
	

}
