package br.com.hubfintech.controlecontas.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.controller.facotories.TransacaoFactory;
import br.com.hubfintech.controlecontas.controller.processo.Processador;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = {RegrasTransacao.class,OperacaoService.class,Processador.class,TransacaoFactory.class })
public class WebservicesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
