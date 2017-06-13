/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * @author eric
 *
 */
public interface TransacaoDao {
	
	/**
	 * busca transacao dado um id
	 * @param id
	 * @return the transacao
	 */
	public Transacao encontrarTransacaoPeloId(String id);

	/**
	 * Inserir nova transacao
	 * @param transacao
	 * @return id da transacao
	 */
	long inserirTransacao(Transacao transacao);

	/**
	 * atualizar transacao
	 * @param transacao
	 */
	public void atualizar(Transacao transacao);
		
	

}
