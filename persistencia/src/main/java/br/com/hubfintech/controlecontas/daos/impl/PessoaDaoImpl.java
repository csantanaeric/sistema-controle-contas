/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.hubfintech.controlecontas.contas.TipoPessoa;
import br.com.hubfintech.controlecontas.daos.PessoaDao;
import br.com.hubfintech.controlecontas.pesssoa.Pessoa;

/**
 * @author Eric
 *
 */
public class PessoaDaoImpl implements PessoaDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PessoaDaoImpl.class);
	
	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "PESSOA";

	private static final String PRIMARY_COLUMN_NAME = "CONTA_ID";

	private static final String SELECT = "SELECT  ";
	private static final String FROM_JURIDICA = " FROM PESSOA_JURIDICA PESSOA";
	private static final String FROM_FISICA = " FROM PESSOA_FISICA  PESSOA";

	//private SimpleJdbcInsert insert;
	
	
    /**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public PessoaDaoImpl(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        //this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public PessoaDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        //this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }
	
	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.daos.PessoaDao#encontrarPessoaPorId(java.lang.Long, br.com.hubfintech.controlecontas.contas.TipoPessoa)
	 */
	@Override
	public Pessoa encontrarPessoaPorId(Long id, TipoPessoa tipoPessoa) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT 	PESSOA.* ");
		sb.append(" FROM 	CONTA_PESSOA 	CP, ");
		if(TipoPessoa.FISICA.equals(tipoPessoa)){
			sb.append(" PESSOA_FISICA PESSOA  ");
		} else {
			sb.append(" PESSOA_JURIDICA	PESSOA ");
		}
		sb.append(" WHERE 	CP.CONTA_PESSOA_ID 	= :CONTA_PESSOA_ID ");
		if(TipoPessoa.FISICA.equals(tipoPessoa)){
			sb.append(" AND CP.PESSOA_FISICA_ID = PESSOA.PESSOA_FISICA_ID ");
		} else {
			sb.append(" AND		CP.PESSOA_FISICA_ID = PESSOA.PESSOA_JURIDICA_ID ");
		}
		final Map<String, Object> map = new HashMap<>();
		map.put("CONTA_PESSOA_ID", id);
		try {
            return this.template.queryForObject(sb.toString(), map, new pessoaMapper(tipoPessoa));
        } catch (final EmptyResultDataAccessException e) {
        	LOGGER.info("Pessao não encontrado");
            return null;
        }
	}

}
