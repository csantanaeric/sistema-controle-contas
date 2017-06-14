/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * @author eric
 *
 */
@Component
public class OperacaoDaoImpl implements OperacaoDao {
	
private static final Logger LOGGER = LoggerFactory.getLogger(ContasDaoImpl.class);
	
	private static final String DELIMITER = ",";
	
	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "OPERACAO";

	private static final String PRIMARY_COLUMN_NAME = "NU_OPERCAO_ID";
	
	private SimpleJdbcInsert insert;
	
    /**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public OperacaoDaoImpl(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
        
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public OperacaoDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }
	
    /*
     * (non-Javadoc)
     * @see br.com.hubfintech.controlecontas.daos.OperacaoDao#inserirOperacao(br.com.hubfintech.controlecontas.transacao.Transacao, br.com.hubfintech.controlecontas.transacao.Transferencia)
     */
    @Override
	public Long inserirOperacao(Transacao transacao,Transferencia transferencia) {
		final Map<String, Object> map = new HashMap<>();
		this.popularDadosTransferencia(transacao,transferencia,map);
		return this.gravarOperacao(map);
	}
    
	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.OperacaoDao#inserirOperacao(br.com.hubfintech.controlecontas.transacao.Aporte)
	 */
	@Override
	public Long inserirOperacao(Transacao transacao,Aporte aporte) {
		final Map<String, Object> map = new HashMap<>();
		this.popularDadosAporte(transacao,aporte,map);
		return this.gravarOperacao(map);
	}

    /**
     * Popula os dados de transferência para persistencia
     * @param transacao
     * @param transferencia
     * @param map
     */
	private void popularDadosTransferencia(Transacao transacao,Transferencia transferencia, Map<String, Object> map) {
		map.put("NU_TRANSACAO_ID",transacao.getTransacaoId());
		map.put("CD_TIPO_OPERACAO", transferencia.getTipoOpercao().getCodigoTipoOpercao());
		map.put("CD_STATUS_OPERACAO", transferencia.getStatus().getCodigoSatus());
		map.put("DT_OPERACAO", transferencia.getDataOpercao());
		map.put("VL_OPERACAO", transferencia.getValor());
		map.put("CONTA_ORIGEM_ID", transferencia.getContaOrigem().getId());
		map.put("CONTA_DESTINO_ID", transferencia.getContaDestino().getId());
	}

	private void popularDadosAporte(Transacao transacao, Aporte aporte, Map<String, Object> map) {
		map.put("NU_TRANSACAO_ID",transacao.getTransacaoId());
		map.put("CD_TIPO_OPERACAO", aporte.getTipoOpercao().getCodigoTipoOpercao());
		map.put("CD_STATUS_OPERACAO", aporte.getStatus().getCodigoSatus());
		map.put("DT_OPERACAO", aporte.getDataOpercao());
		map.put("VL_OPERACAO", aporte.getValor());
		map.put("CONTA_DESTINO_ID", aporte.getConta().getId());
		map.put("CD_APORTE", aporte.getCodigoAporte());
	}

	@Override
	public void inserirOperacao(Estorno estorno) {
		
		
	}
	
	
	private Long gravarOperacao(Map<String, Object> map) {
        final StringJoiner keys = new StringJoiner(DELIMITER);
        final StringJoiner values = new StringJoiner(DELIMITER);
        map.keySet().stream().forEach(key -> {
            keys.add(key);
            values.add(":" + key);
        });
        
        final Number key = this.insert.executeAndReturnKey(map);
        long id = key.longValue();
        LOGGER.info("Inserido operação de id:({})",id);
        return id;
		
	}
	

}
