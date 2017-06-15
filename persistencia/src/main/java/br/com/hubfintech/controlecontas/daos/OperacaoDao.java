/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * Dao de persistencias das operacoes
 * @author eric
 *
 */
public interface OperacaoDao {

	/**
	 * Persiste operacao
	 * @param transacao
	 * @param transferencia
	 * @return id da operação
	 */
	Long inserirOperacao(Transacao transacao, Transferencia transferencia);
	
	/**
	 * Persiste estorno
	 * @param transacao
	 * @param transferencia
	 * @return id da operação
	 */
	Long inserirOperacao(Transacao transacao, Estorno estorno);
	
	/**
	 * Persiste aporte
	 * @param transacao
	 * @param aporte
	 * @return  id da operação
	 */
	Long inserirOperacao(Transacao transacao, Aporte aporte);
	
}
