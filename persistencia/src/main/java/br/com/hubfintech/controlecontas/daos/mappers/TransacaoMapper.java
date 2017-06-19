/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * Mapeamento dos campos do banco com os atributos das classe entidade Transacao.
 * @author eric
 *
 */
@Component
public class TransacaoMapper implements RowMapper<Transacao> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Transacao mapRow(ResultSet rs, int position) throws SQLException {
		Transacao transacao = new Transacao();
		transacao.setTransacaoId(rs.getLong("NU_TRANSACAO_ID"));
		transacao.setData(new Date(rs.getTimestamp("DT_TRANSACAO").getTime()));
		transacao.setCodigoAporte(rs.getString("CD_APORTE"));
		//transacao.setOperacao(new Transferencia());
		return transacao;
	}

}
