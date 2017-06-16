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
import br.com.hubfintech.controlecontas.transacao.Operacao;
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

	private static final String PRIMARY_COLUMN_NAME = "NU_OPERACAO_ID";
	
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
     * Construtor que instancia o template jdbc
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public OperacaoDaoImpl(final JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
        this.template = new NamedParameterJdbcTemplate(this.jdbcTemplate);
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
	
	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.OperacaoDao#inserirOperacao(br.com.hubfintech.controlecontas.transacao.Transacao, br.com.hubfintech.controlecontas.transacao.Estorno)
	 */
	@Override
	public Long inserirOperacao(Transacao transacao,Estorno estorno) {
		final Map<String, Object> map = new HashMap<>();
		this.popularDadosEstorno(transacao,estorno,map);
		return this.gravarOperacao(map);
	}
	
	/**
	 * Popula os dados de transferencia para persistencia
	 * @param transacao
	 * @param estorno
	 * @param map
	 */
    private void popularDadosEstorno(Transacao transacao, Estorno estorno, Map<String, Object> map) {
    	this.populaDadosComum(transacao, estorno, map);
	}

	/**
     * Popula os dados de transferência para persistencia
     * @param transacao
     * @param transferencia
     * @param map
     */
	private void popularDadosTransferencia(Transacao transacao,Transferencia transferencia, Map<String, Object> map) {
		this.populaDadosComum(transacao, transferencia, map);
	}

	/**
	 * Popula os dados de aporte para persistencia
	 * @param transacao
	 * @param aporte
	 * @param map
	 */
	private void popularDadosAporte(Transacao transacao, Aporte aporte, Map<String, Object> map) {
		this.populaDadosComum(transacao, aporte, map);
	}

	/**
	 * popula dados comum operação
	 * @param transacao
	 * @param operacao
	 * @param map
	 */
	private void populaDadosComum(Transacao transacao, Operacao operacao, Map<String, Object> map ){
		map.put("CD_APORTE", operacao.getCodigoAporte());
		map.put("NU_TRANSACAO_ID",transacao.getTransacaoId());
		map.put("CD_TIPO_OPERACAO", operacao.getTipoOperacao().getCodigoTipoOpercao());
		map.put("CD_STATUS_OPERACAO", operacao.getStatus().getCodigoSatus());
		map.put("DT_OPERACAO", operacao.getDataOpercao());
		map.put("VL_OPERACAO", operacao.getValor());
		map.put("CONTA_ORIGEM_ID", operacao.getContaOrigem().getId());
		map.put("CONTA_DESTINO_ID", operacao.getContaDestino().getId());
	}
	
	/**
	 * Grava operação
	 * @param map
	 * @return id da operacao
	 */
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
