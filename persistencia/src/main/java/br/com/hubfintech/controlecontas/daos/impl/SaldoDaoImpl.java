/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.daos.SaldoDao;

/**
 * @author eric
 *
 */
@Component
public class SaldoDaoImpl implements SaldoDao {

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContasDaoImpl.class);
	
	private static final String DELIMITER = ",";
	
	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "SALDO";

	private static final String PRIMARY_COLUMN_NAME = "SALDO_ID";

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
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }
	
	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.SaldoDao#inserir()
	 */
	@Override
	public List<Saldo> inserir(Saldo... saldos) {
		List<Saldo> listaSaldo = new ArrayList<>();
		for(Saldo saldo : saldos){
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
			listaSaldo.add(saldo);
		}
		return listaSaldo;
	}

	private void popularDadosSaldo(Saldo saldo, Map<String, Object> map) {
		map.put("CONTA_ID", saldo.getContaId());
		map.put("SALDO", saldo.getValor());
		map.put("DH_ATUALIZACAO", saldo.getDataAtualizacao());
	}
}
