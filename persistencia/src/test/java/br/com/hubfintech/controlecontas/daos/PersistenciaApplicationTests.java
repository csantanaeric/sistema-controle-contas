package br.com.hubfintech.controlecontas.daos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.transacao.Transacao;

import static org.junit.Assert.assertNotNull;



@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = {TransacaoDao.class })
public class PersistenciaApplicationTests {
	
	@Autowired
	private TransacaoDao transacaoDao;
	
//	private EmbeddedDatabase db;
	
//    @Before
//    public void setUp() {
//        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
//    	db = new EmbeddedDatabaseBuilder()
//    		.setType(EmbeddedDatabaseType.DERBY)
//    		.addScript("create-db.sql")
//    		.addScript("insert-data.sql")
//    		.build();
//    }
//
//	@Test
//	public void contextLoads() {
//		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
//		
//	}
	
	@Test
	public void testeInsereEConsultaTransacao() {
		Transacao transacao = new Transacao();
		long id = transacaoDao.inserirTransacao(transacao);
		assertNotNull("Deveria ser retornado o id da transacao que foi inserido no banco",id);
		transacao =  transacaoDao.encontrarTransacaoPeloId(String.valueOf(id));
		assertNotNull("Transacao deveria ser encontrado.",transacao);
		
	}

}
