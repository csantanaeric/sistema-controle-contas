package br.com.hubfintech.controlecontas.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.facotories.TransacaoFactory;
import br.com.hubfintech.controlecontas.controller.processo.Processador;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.controller.servicos.impl.TransferenciaService;
import br.com.hubfintech.controlecontas.daos.ContasDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = {RegrasTransacao.class,OperacaoService.class,Processador.class,TransacaoFactory.class, TransacaoDao.class, ContasDao.class })
public class ControllerApplicationTests {

	@Autowired
	private TransferenciaService transferenciaService;
	
	@Autowired
	private TransacaoFactory transacaoFactory;
	
	@Test
	public void transferenciaTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createRequest());
		transferenciaService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	@Test
	public void transferenciaTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createRequest());
		transferenciaService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}

	private Request createRequest() {
		TransferenciaRequest request = new TransferenciaRequest();
		request.setContaOrigem("111");
		request.setContaDestino("112");
		request.setValor("500.10");
		return request;
	}


}
