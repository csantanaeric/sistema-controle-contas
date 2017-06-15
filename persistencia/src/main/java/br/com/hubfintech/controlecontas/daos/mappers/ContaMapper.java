package br.com.hubfintech.controlecontas.daos.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.StatusConta;
import br.com.hubfintech.controlecontas.contas.TipoPessoa;
import br.com.hubfintech.controlecontas.daos.PessoaDao;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.utils.ContasUtils;

/**
 * Mapeamento dos campos do banco com os atributos das classe entidade Saldo.
 * @author Eric
 *
 */
@Component
@Scope("prototype")
public class ContaMapper implements RowMapper<Conta> {

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private SaldoDao saldoDao;
	
	@Override
	public Conta mapRow(ResultSet rs, int position) throws SQLException {
		Conta conta = new Conta();
		conta.setNome(rs.getString("NOME"));
		conta.setId(rs.getLong("CONTA_ID"));
		conta.setTipoPessoa("F".equals(rs.getString("TP_PESSOA")) ? TipoPessoa.FISICA : TipoPessoa.JURIDICA);
		long contaPessoaoId = rs.getLong("CONTA_PESSOA_ID");
		conta.setPessoa(pessoaDao.encontrarPessoaPorId(contaPessoaoId, conta.getTipoPessoa()));
		Long contaPaiId = rs.getLong("CONTA_PAI_ID");
		Long contaPaiMatrizId = rs.getLong("CONTA_PAI_MATRIZ_ID");
		conta.setContaPai(contaPaiId == null ? null : new Conta(rs.getLong("CONTA_PAI_ID")) );
		conta.setContaPaiMatriz(contaPaiMatrizId == null ? null : new Conta(rs.getLong("CONTA_PAI_MATRIZ_ID")) );
		conta.setStatusConta(StatusConta.getStatusConta(rs.getString("STATUS")));
		conta.setSaldos(saldoDao.buscarListaDeSaldos(conta.getId()));
		return conta;
	}
	
	
	
	

}
