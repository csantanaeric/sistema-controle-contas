/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;import br.com.hubfintech.controlecontas.transacao.Operacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * @author cafalchio
 *
 */
public class TransacaoMapper implements RowMapper<Transacao> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Transacao mapRow(ResultSet rs, int position) throws SQLException {
		Transacao transacao = new Transacao();
		transacao.setTransacaoId(rs.getString("NU_TRANSACAO_ID"));
		transacao.setData(new Date(rs.getTimestamp("DT_TRANSACAO").getTime()));
		transacao.setOperacao(new Transferencia());
		return transacao;
	}

}
