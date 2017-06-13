package br.com.hubfintech.controlecontas.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.transacao.Transacao;



@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = {TransacaoDao.class })
public class PersistenciaApplicationTests {
	
	@Autowired
	private TransacaoDao transacaoDao;
	
	@Autowired
	private ContasDao contasDao;
	
	@Test @Ignore
	public void testeInsereEConsultaTransacao() {
		Transacao transacao = new Transacao();
		long id = transacaoDao.inserirTransacao(transacao);
		assertNotNull("Deveria ser retornado o id da transacao que foi inserido no banco",id);
		transacao =  transacaoDao.encontrarTransacaoPeloId(String.valueOf(id));
		assertNotNull("Transacao deveria ser encontrado.",transacao);
	}
	
	@Test 
	public void testeConsultaConta(){
		Conta conta = contasDao.encontrarContaPeloNome("121");
		assertNotNull("Conta de nome 121 deveria ser encontrado.",conta);
	}

}
