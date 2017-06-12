package br.com.hubfintech.controlecontas.contas;

/**
 * Classe que representa uma conta filial. Esta classe possui obrigatoriamente
 * uma conta Pai (pode ser a Conta Matriz ou outra Conta Filial) e pode ou não
 * ter uma Conta Filial abaixo.
 * 
 * @author Eric
 *
 */
public class ContaFilial extends Conta {

	/** the conta pai */
	private Conta contaPai;
	
	public ContaFilial(Conta conta) {
		super();
		this.contaPai = conta;
	}

	/**
	 * @return the conta
	 */
	public Conta getConta() {
		return contaPai;
	}

	/**
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(Conta conta) {
		this.contaPai = conta;
	}

}
