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
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.daos.AbstractDao;
import br.com.hubfintech.controlecontas.daos.ContasDao;
import br.com.hubfintech.controlecontas.daos.mappers.ContaMapper;


/**
 * 
 * @author eric
 *
 */
@Service
@Scope("prototype")
public class ContasDaoImpl implements ContasDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContasDaoImpl.class);
	
	private static final String DELIMITER = ",";
	
	private NamedParameterJdbcTemplate template;
	
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "CONTA";

	private static final String PRIMARY_COLUMN_NAME = "CONTA_ID";

	private static final String QUERY_ECONTRAR_CONTA_POR_NOME = "SELECT * FROM CONTA WHERE NOME = :NOME";

	private static final String QUERY_ECONTRAR_CONTA_POR_ID = "SELECT * FROM CONTA WHERE CONTA_ID = :CONTA_ID";

	private SimpleJdbcInsert insert;
	
	@Autowired
	private ContaMapper contaMapper;
	
	/**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public ContasDaoImpl(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public ContasDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TABLE_NAME).usingGeneratedKeyColumns(PRIMARY_COLUMN_NAME);
    }



	@Override
	public Conta encontrarContaPeloNome(String nome) {
		final Map<String, Object> map = new HashMap<>();
		map.put("NOME", nome);
		try {
            Conta conta = this.template.queryForObject(QUERY_ECONTRAR_CONTA_POR_NOME, map, contaMapper);
            this.popularContasPais(conta);
            return conta;
        } catch (final EmptyResultDataAccessException e) {
        	LOGGER.info("Conta não encontrada",e);
        	return null;
        }
	}
	
	@Override
	public Conta encontrarContaPeloId(Long contaPaiId) {
		Conta conta = this.executarContaPeloId(contaPaiId);
		this.popularContasPais(conta);
		return conta;
	}
	
	/**
	 * Busca e popula contas pais
	 * @param conta
	 */
	private void popularContasPais(Conta conta){
		if(conta != null){
			if(conta.getContaPaiMatriz() != null){
	        	conta.setContaPaiMatriz(this.executarContaPeloId(conta.getContaPaiMatriz().getId()));
	        }
	        if(conta.getContaPai() != null){
	        	conta.setContaPai(this.executarContaPeloId(conta.getContaPai().getId()));
	        }
		}
    }
	
	/**
	 * Executa consulta por id
	 * @param contaPaiId
	 * @return
	 */
	private Conta executarContaPeloId(Long contaPaiId) {
		final Map<String, Object> map = new HashMap<>();
		map.put("CONTA_ID", contaPaiId);
		try {
            return this.template.queryForObject(QUERY_ECONTRAR_CONTA_POR_ID, map, contaMapper);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.info("Conta não encontrada",e);
            return null;
        }
	}

	@Override
	public void inserirConta(Conta conta) {

	}

}
