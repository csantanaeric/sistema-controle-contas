/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * Dao de persistencias das operacoes
 * @author eric
 *
 */
public interface OperacaoDao {

	/**
	 * persiste trasnferencia
	 * @param transferencia
	 */
	void inserirOperacao(Transferencia transferencia);
	
	/**
	 * persiste  aporte
	 * @param aporte
	 */
	void inserirOperacao(Aporte aporte);
	
	/**
	 * persiste estorno
	 * @param estorno
	 */
	void inserirOperacao(Estorno estorno);
	
}
