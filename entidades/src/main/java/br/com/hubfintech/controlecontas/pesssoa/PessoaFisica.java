/**
 * 
 */
package br.com.hubfintech.controlecontas.pesssoa;

import java.util.Date;

/**
 * Pessoa fisica
 * @author eric
 *
 */
public class PessoaFisica extends Pessoa {
	
	/** nome da pessoa */
	private String nome;
	
	/** cpf da pessoa */
	private String cpf;
	
	/** data de nascimento da pessoa */
	private Date dataNascimento;

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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PessoaFisica [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", toString()="
				+ super.toString() + "]";
	}
	
}
