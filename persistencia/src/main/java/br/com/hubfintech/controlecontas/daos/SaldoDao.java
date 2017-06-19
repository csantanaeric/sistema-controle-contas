/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import java.util.List;

import br.com.hubfintech.controlecontas.contas.Saldo;

/**
 * @author eric
 *
 */
public interface SaldoDao {
	
	void inserir(Saldo... saldos);

	List<Saldo> buscarListaDeSaldos(Long id);

}
