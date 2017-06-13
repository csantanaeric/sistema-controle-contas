package br.com.hubfintech.controlecontas.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.TipoPessoa;
import br.com.hubfintech.controlecontas.daos.PessoaDao;

/**
 * Mapeia recursivamente as contas e contas pai
 * @author Eric
 *
 */
@Component
@Scope("prototype")
public class ContaMapper implements RowMapper<Conta> {

	@Autowired
	private PessoaDao pessoaDao;

	
	
	@Override
	public Conta mapRow(ResultSet rs, int position) throws SQLException {
		Conta conta = new Conta();
		conta.setNome(rs.getString("NOME"));
		conta.setSaldo(rs.getDouble("SALDO"));
		conta.setTipoPessoa("F".equals(rs.getString("TP_PESSOA")) ? TipoPessoa.FISICA : TipoPessoa.JURIDICA);
		long contaPessoaoId = rs.getLong("CONTA_PESSOA_ID");
		conta.setPessoa(pessoaDao.encontrarPessoaPorId(contaPessoaoId, conta.getTipoPessoa()));
		Long contaPaiId = rs.getLong("CONTA_PAI_ID");
		Long contaPaiMatrizId = rs.getLong("CONTA_PAI_MATRIZ_ID");
		conta.setContaPai(contaPaiId == null ? null : new Conta(rs.getLong("CONTA_PAI_ID")) );
		conta.setContaPaiMatriz(contaPaiMatrizId == null ? null : new Conta(rs.getLong("CONTA_PAI_MATRIZ_ID")) );
		return conta;
	}

}
