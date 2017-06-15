package br.com.hubfintech.controlecontas.daos.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Saldo;

/**
 * Mapeamento dos campos do banco com os atributos das classe entidade Saldo.
 * @author Eric
 */
@Component
public class SaldoMapper implements RowMapper<Saldo> {

	@Override
	public Saldo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Saldo saldo = new Saldo();
		saldo.setId(rs.getLong("SALDO_ID"));
		saldo.setContaId(rs.getLong("CONTA_ID"));
		saldo.setValor(rs.getDouble("SALDO"));
		saldo.setDataAtualizacao(rs.getDate("DH_ATUALIZACAO"));
		return saldo;
	}

}
