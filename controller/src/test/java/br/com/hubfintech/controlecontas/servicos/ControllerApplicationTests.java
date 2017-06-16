package br.com.hubfintech.controlecontas.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.facotories.TransacaoFactory;
import br.com.hubfintech.controlecontas.controller.processo.Processador;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.controller.servicos.impl.AporteService;
import br.com.hubfintech.controlecontas.controller.servicos.impl.EstornoService;
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
	private AporteService aporteService;
	
	@Autowired
	private EstornoService estornoService;
	
	@Autowired
	private TransacaoFactory transacaoFactory;
	
	@Test @Ignore
	public void transferenciaTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createTransferenciaRequest());
		transferenciaService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	@Test @Ignore
	public void aporteTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createAporteRequest());
		aporteService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	@Test
	public void estornoAporteTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createEstornoTransferenciaRequest());
		aporteService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	private Request createEstornoTransferenciaRequest() {
		//this.prepararTesteAporte();
		EstornoRequest request = new EstornoRequest();
		request.setCodigoAporte("e25fe2f1e40a74c43a09bf2937611ab4");
		request.setValor("0");
		return request;
	}

	public void estornoTrasnferenciaTest() throws RegrasNegocioException{
		Transacao transacao = transacaoFactory.create(createAporteRequest());
		aporteService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}

	private Request createAporteRequest() {
		AporteRequest aporteRequest = new AporteRequest();
		aporteRequest.setContaBeneficiada("1");
		aporteRequest.setValor("500.10");
		return aporteRequest;
	}

	private Request createTransferenciaRequest() {
		TransferenciaRequest request = new TransferenciaRequest();
		request.setContaOrigem("111");
		request.setContaDestino("112");
		request.setValor("500.10");
		return request;
	}


}
