package br.com.hubfintech.controlecontas.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.hubfintech.controlecontas.contas.TipoPessoa;
import br.com.hubfintech.controlecontas.pesssoa.Pessoa;
import br.com.hubfintech.controlecontas.pesssoa.PessoaFisica;
import br.com.hubfintech.controlecontas.pesssoa.PessoaJuridica;

/**
 * 
 * @author Eric
 *
 */
public class pessoaMapper implements RowMapper<Pessoa> {

	private TipoPessoa TipoPessoa;

	public pessoaMapper(TipoPessoa tipoPessoa) {
		this.TipoPessoa = tipoPessoa;
	}

	@Override
	public Pessoa mapRow(ResultSet rs, int arg1) throws SQLException {
		
		if(TipoPessoa.FISICA.equals(TipoPessoa)){
			PessoaFisica pessoa = new PessoaFisica();
			pessoa.setCpf(rs.getString("CPF"));
			pessoa.setNome(rs.getString("NOME_COMPLETO"));
			pessoa.setDataNascimento(rs.getTimestamp("DT_NASCIMENTO"));
			return pessoa;
		} else {
			PessoaJuridica pessoa = new PessoaJuridica();
			pessoa.setCnpj(rs.getString("CNPJ"));
			pessoa.setNomeFantasia("NOME_FANTASIA");
			pessoa.setRazaoSocial("RAZAO_SOCIAL");
			return pessoa;
		}
	}
}
