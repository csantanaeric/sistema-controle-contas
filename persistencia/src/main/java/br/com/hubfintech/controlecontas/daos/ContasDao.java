/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * @author eric
 *
 */
public interface ContasDao {

	/**
	 * Encontrar a conta pelo nome
	 * @param nome
	 * @return the conta
	 */
	Conta encontrarContaPeloNome(String nome);
	
	
	public void inserirConta(Conta conta);


	Conta encontrarContaPeloId(Long contaPaiId);

}
