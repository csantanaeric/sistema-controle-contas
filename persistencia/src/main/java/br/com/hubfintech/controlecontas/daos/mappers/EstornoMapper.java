/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Operacao;

/**
 * @author Eric
 *
 */
@Component
public class EstornoMapper implements RowMapper<Operacao> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Operacao mapRow(ResultSet rs, int rowNum) throws SQLException {

				
		return null;
	}

}
