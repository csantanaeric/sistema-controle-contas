/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import br.com.hubfintech.controlecontas.contas.TipoPessoa;
import br.com.hubfintech.controlecontas.pesssoa.Pessoa;

/**
 * @author Eric
 *
 */
public interface PessoaDao {
	
	/**
	 * Encontra a pessoa
	 * @param id
	 * @param tipoPessoa
	 * @return the pessoa
	 */
	public Pessoa encontrarPessoaPorId(Long id, TipoPessoa tipoPessoa);

}
