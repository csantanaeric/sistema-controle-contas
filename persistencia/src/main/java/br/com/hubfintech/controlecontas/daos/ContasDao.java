/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * Interface de contasDao
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
	
	/**
	 * inserir nova conta
	 * @param conta
	 */
	public void inserirConta(Conta conta);


	/**
	 * Encontra uma conta dado o id
	 * @param contaPaiId
	 * @return conta
	 */
	public Conta encontrarContaPeloId(Long contaPaiId);

	/**
	 * Atualiza saldo da conta
	 * @param contas
	 */
	void atualizarSaldo(Conta contas, Double saldo);

	

}
