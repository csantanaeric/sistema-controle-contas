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
	
	List<Saldo> inserir(Saldo... saldos);

	List<Saldo> buscarListaDeSaldos(Long id);

}
