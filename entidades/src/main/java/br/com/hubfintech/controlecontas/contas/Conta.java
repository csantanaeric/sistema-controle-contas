/**
 * 
 */
package br.com.hubfintech.controlecontas.contas;

import java.util.Date;
import java.util.List;

import br.com.hubfintech.controlecontas.pesssoa.Pessoa;

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
	
	private TipoPessoa tipoPessoa;
	
	/** the pessoa (fisica ou juridica) */
	private Pessoa pessoa;
	
	
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

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", dataCriacao=" + dataCriacao + ", saldo=" + saldo + ", contaPai=" + contaPai
				+ ", contaPaiMatriz=" + contaPaiMatriz + ", pessoa=" + pessoa + ", contasFilhas=" + contasFilhas + "]";
	}

	/**
	 * @return the tipoPessoa
	 */
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
