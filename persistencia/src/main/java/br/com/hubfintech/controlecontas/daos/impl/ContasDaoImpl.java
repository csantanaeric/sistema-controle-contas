/**
 * 
 */
package br.com.hubfintech.controlecontas.daos.impl;

import java.util.StringJoiner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.daos.ContasDao;

/**
 * 
 * @author eric
 *
 */
@Service
public class ContasDaoImpl implements ContasDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContasDaoImpl.class);
	
	private static final String DELIMITER = ",";
	
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * Construtor que instancia o template jdbc baseado no dado data source
	 * @param dataSource
	 */
	@Autowired
	public ContasDaoImpl(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}



	@Override
	public Conta encontrarContaPeloNome(String nome) {
		Conta conta = new Conta();
		conta.setNome(nome);
		return conta;
	}



	@Override
	public void inserirConta(Conta conta) {
		// TODO Auto-generated method stub
		
	}



//	@Override
//	public void inserirConta(Conta conta) {
//        final StringJoiner keys = new StringJoiner(DELIMITER);
//        final StringJoiner values = new StringJoiner(DELIMITER);
//        map.keySet().stream().forEach(key -> {
//            keys.add(key);
//            values.add(":" + key);
//        });
//
//        this.template.update("INSERT INTO TBSKLR_TRANS_ACCOUNT_VERIFY(" + keys + ") VALUES (" + values + ")", map);
//	}
	
	
	
}
