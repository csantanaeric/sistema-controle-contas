/**
 * 
 */
package br.com.hubfintech.controlecontas.daos;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * @author Eric
 *
 */
public abstract class AbstractDao {
	
	protected static final String DELIMITER = ",";
	
	protected NamedParameterJdbcTemplate template;
	
	protected JdbcTemplate jdbcTemplate;
	
	protected SimpleJdbcInsert insert;
	
	private String tableName; 
	
	private String primaryColumnName;
	
    /**
     * Construtor que instancia o template baseado no dado datasource
     * @param dataSource
     */
    @Autowired(required = false)
    public AbstractDao(final DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.instanciarSimpleSjdbInsert(this.tableName, this.primaryColumnName);
    }

    /**
     * Construtor que instancia o template baseado no dado jdbcTemplate
     * @param jdbcTemplate 
     */
    @Autowired(required = false)
    public AbstractDao(final JdbcTemplate jdbcTemplate) {
        this.template = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
        this.instanciarSimpleSjdbInsert(this.tableName, this.primaryColumnName);
    }
    
    protected void instanciarSimpleSjdbInsert(String tableName, String primaryColumnName){
    	this.carregarDadosTabela(tableName,primaryColumnName);
    	if(tableName != null && this.primaryColumnName != null){
    		this.insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(tableName).usingGeneratedKeyColumns(primaryColumnName);
    	}
    }

	protected abstract void carregarDadosTabela(String tableName, String primaryColumnName);
    
}
