/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * @author eric
 *
 */
@Component
public class TransacaoDaoImpl implements TransacaoDao {
	
	private static final String DELIMITER = ",";


	private static final String QUERY_ECONTRAR_TRANSACAO_POR_ID = "SELECT * FROM TRANSACAO WHERE NU_TRANSACAO_ID = :NU_TRANSACAO_ID";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransacaoDaoImpl.class);

	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "TRANSACAO";

	private static final String PRIMARY_COLUMN_NAME = "NU_TRANSACAO_ID";

	private SimpleJdbcInsert insert;
	
    /**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public TransacaoDaoImpl(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public TransacaoDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.TransacaoDao#encontrarTransacaoPeloId(java.lang.String)
	 */
	@Override
	public Transacao encontrarTransacaoPeloId(String id) {
		final Map<String, Object> map = new HashMap<>();
		map.put("NU_TRANSACAO_ID", id);
		try {
            return this.template.queryForObject(QUERY_ECONTRAR_TRANSACAO_POR_ID, map, new TransacaoMapper());
        } catch (final EmptyResultDataAccessException e) {
            return null;
        }
	}
	

	@Override
	public long inserirTransacao(Transacao transacao) {
		final Map<String, Object> map = new HashMap<>();
		this.popularDadosTransacao(transacao,map);
        final StringJoiner keys = new StringJoiner(DELIMITER);
        final StringJoiner values = new StringJoiner(DELIMITER);
        map.keySet().stream().forEach(key -> {
            keys.add(key);
            values.add(":" + key);
        });
        
        final Number key = this.insert.executeAndReturnKey(map);
        long id = key.longValue();
        LOGGER.info("Inserido transacao de id:({})",id);
        return id;
        //this.insert.update("INSERT INTO TRANSACAO(" + keys + ") VALUES (" + values + ")", map);
	}


	private void popularDadosTransacao(Transacao transacao, Map<String, Object> map) {
		transacao.setData(new Date());
		map.put("DT_TRANSACAO", transacao.getData());
	}

	@Override
	public void atualizar(Transacao transacao) {
		// TODO Auto-generated method stub
		
	}

}
