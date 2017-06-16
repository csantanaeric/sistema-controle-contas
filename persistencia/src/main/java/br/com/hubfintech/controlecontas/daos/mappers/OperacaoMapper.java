/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Operacao;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.TipoOperacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * @author Eric
 *
 */
@Component
public class OperacaoMapper implements RowMapper<Operacao> {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public Operacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoOperacao tipoOperacao = TipoOperacao.getTipoOperacao(Integer.valueOf(rs.getString("CD_TIPO_OPERACAO")));
		Operacao operacao = this.getInstanciaOperacao(tipoOperacao);
		if(operacao != null){
			operacao.setId(rs.getLong("NU_OPERACAO_ID"));
			String status = rs.getString("CD_STATUS_OPERACAO");
			operacao.setStatus(StatusOperacao.NEGADO.getCodigoSatus().equals(status) || StringUtils.isBlank(status)
					? StatusOperacao.NEGADO : StatusOperacao.APROVADO);
			operacao.setTipoOperacao(tipoOperacao);
			operacao.setDataOpercao(rs.getDate("DT_OPERACAO"));
			operacao.setValor(rs.getDouble("VL_OPERACAO"));
			Long contaDestinoId = rs.getLong("CONTA_DESTINO_ID");
			Long contaOrigemId = rs.getLong("CONTA_ORIGEM_ID");
			operacao.setContaDestino(contaDestinoId != null ? new Conta(contaDestinoId) : null);
			operacao.setContaOrigem(contaOrigemId != null ? new Conta(contaOrigemId) : null);
		}
		
		return operacao;
	}

	private Operacao getInstanciaOperacao(TipoOperacao tipoOperacao) {
		switch (tipoOperacao) {
		case TRANSFERENCIA:
			return new Transferencia();
		case APORTE:
			return new Aporte();
		case ESTORNO:
			return new Estorno();
		default:
			return null;
		}

	}
}
