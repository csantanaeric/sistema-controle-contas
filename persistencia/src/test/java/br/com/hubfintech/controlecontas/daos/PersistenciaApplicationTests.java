package br.com.hubfintech.controlecontas.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.transacao.Transacao;



@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = {TransacaoDao.class })
public class PersistenciaApplicationTests {
	
	@Autowired
	private TransacaoDao transacaoDao;
	
	@Test
	public void testeInsereEConsultaTransacao() {
		Transacao transacao = new Transacao();
		long id = transacaoDao.inserirTransacao(transacao);
		assertNotNull("Deveria ser retornado o id da transacao que foi inserido no banco",id);
		transacao =  transacaoDao.encontrarTransacaoPeloId(String.valueOf(id));
		assertNotNull("Transacao deveria ser encontrado.",transacao);
	}

}
