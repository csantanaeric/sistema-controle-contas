/**
 * 
 */
package br.com.hubfintech.controlecontas.contas;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa uma conta
 * @author Eric
 *
 */
public class Conta {

	/** the nome da conta */
	private String nome;
	
	/** the data de criação da conta */
	private Date dataCriacao;
	
	/** the Saldo da conta */
	private Double saldo;
	
	/** the conta pai */
	private Conta contaPai;
	
	/** the conta pai principal */
	private Conta contaPaiMatriz;
	
	
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

	/**
	 * @return the contaPai
	 */
	public Conta getContaPai() {
		return contaPai;
	}

	/**
	 * @param contaPai the contaPai to set
	 */
	public void setContaPai(Conta contaPai) {
		this.contaPai = contaPai;
	}

	/**
	 * 
	 * @return the contaPaiMatriz ou nulo se esta conta for a uma conta matriz
	 */
	public Conta getContaPaiMatriz() {
		return contaPaiMatriz;
	}

	/**
	 * @param contaPaiMatriz the contaPaiMatriz to set
	 */
	public void setContaPaiMatriz(Conta contaPaiMatriz) {
		this.contaPaiMatriz = contaPaiMatriz;
	}

	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", dataCriacao=" + dataCriacao + ", saldo=" + saldo + ", contaPai=" + contaPai
				+ ", contaPaiMatriz=" + contaPaiMatriz + ", contasFilhas=" + contasFilhas + "]";
	}
	
}
