/**
 * 
 */
package br.com.hubfintech.controlecontas.pesssoa;

/**
 * Pessoa juridica
 * @author eric
 *
 */
public class PessoaJuridica extends Pessoa {
	
	/** cnpj da pessoa  */
	private String cnpj;
	
	/** nome fantasia  */
	private String razaoSocial;
	
	/** nome fantasia  */
	private String nomeFantasia;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", toString()=" + super.toString() + "]";
	}
	
}
