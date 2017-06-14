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

	/** the id da conta */
	private Long id;
	
	/** the nome da conta */
	private String nome;
	
	/** the data de criação da conta */
	private Date dataCriacao;
	
	/** the Saldo da conta */
	private List<Saldo> saldos;
	
	/** the conta pai */
	private Conta contaPai;
	
	/** the conta pai principal */
	private Conta contaPaiMatriz;
	
	private TipoPessoa tipoPessoa;
	
	/** the pessoa (fisica ou juridica) */
	private Pessoa pessoa;
	
	/** Status da conta */
	private StatusConta statusConta;
	
	
	/** the lista de contas filhas */
	private List<Conta> contasFilhas;

	public Conta(){}
	
	public Conta(long id) {
		this.id = id;
	}

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
	 * @return the saldos
	 */
	public List<Saldo> getSaldos() {
		return saldos;
	}

	/**
	 * @param saldos the saldos to set
	 */
	public void setSaldos(List<Saldo> saldos) {
		this.saldos = saldos;
	}

	/**
	 * @return the statusConta
	 */
	public StatusConta getStatusConta() {
		return statusConta;
	}

	/**
	 * @param statusConta the statusConta to set
	 */
	public void setStatusConta(StatusConta statusConta) {
		this.statusConta = statusConta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conta [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", saldos=" + saldos
				+ ", contaPai=" + contaPai + ", contaPaiMatriz=" + contaPaiMatriz + ", tipoPessoa=" + tipoPessoa
				+ ", pessoa=" + pessoa + ", statusConta=" + statusConta + ", contasFilhas=" + contasFilhas + "]";
	}
	
	
	
}
