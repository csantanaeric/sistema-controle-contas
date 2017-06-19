/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.mappers.SaldoMapper;

/**
 * Implementação da classe de persistencia Saldo
 * @author eric
 */
@Component
public class SaldoDaoImpl implements SaldoDao {

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContasDaoImpl.class);
	
	private static final String DELIMITER = ",";
	
	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "SALDO";

	private static final String PRIMARY_COLUMN_NAME = "SALDO_ID";

	private static final String QUERY_ECONTRAR_SALDOS = "SELECT * FROM SALDO WHERE CONTA_ID = ?";
	
	@Autowired
	private SaldoMapper saldoMapper;

		private SimpleJdbcInsert insert;

	/**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public SaldoDaoImpl(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public SaldoDaoImpl(final JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
        this.template = new NamedParameterJdbcTemplate(this.jdbcTemplate);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }
	
	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.SaldoDao#inserir()
	 */
	@Override
	public void inserir(Saldo... saldos) {
		for(Saldo saldo : saldos){
			if(saldo == null){
				continue;
			}
			final Map<String, Object> map = new HashMap<>();
			this.popularDadosSaldo(saldo, map);
			final StringJoiner keys = new StringJoiner(DELIMITER);
			final StringJoiner values = new StringJoiner(DELIMITER);
			map.keySet().stream().forEach(key -> {
				keys.add(key);
				values.add(":" + key);
			});

			final Number key = this.insert.executeAndReturnKey(map);
			long id = key.longValue();
			saldo.setId(id);
			LOGGER.info("Inserido conta de id:({})", id);
		}
	}

	private void popularDadosSaldo(Saldo saldo, Map<String, Object> map) {
		map.put("CONTA_ID", saldo.getContaId());
		map.put("SALDO", saldo.getValor());
		map.put("DH_ATUALIZACAO", saldo.getDataAtualizacao());
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.SaldoDao#buscarListaDeSaldos(java.lang.Long)
	 */
	@Override
	public List<Saldo> buscarListaDeSaldos(Long contaId) {
		final Map<String, Object> map = new HashMap<>();
		map.put("CONTA_ID", contaId);
		try {
			return jdbcTemplate.query(QUERY_ECONTRAR_SALDOS, new Object [] {contaId}, new int[]{ Types.NUMERIC}, saldoMapper);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.info("Saldo não encontrada",e);
            return new ArrayList<>();
        }
	}
}
