package br.com.hubfintech.controlecontas.servicos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.contas.StatusConta;
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
import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.daos.SaldoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.pesssoa.Pessoa;
import br.com.hubfintech.controlecontas.pesssoa.PessoaFisica;
import br.com.hubfintech.controlecontas.transacao.Operacao;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.TipoOperacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = { RegrasTransacao.class, OperacaoService.class, Processador.class,
		TransacaoFactory.class, TransacaoDao.class, ContasDao.class })
public class ControllerApplicationTests {

	@Autowired
	@Qualifier("transferenciaService")
	private TransferenciaService transferenciaService;
	
	@Autowired
	@Qualifier("aporteService")
	private AporteService aporteService;
	
	@Autowired
	@Qualifier("estornoService")
	private EstornoService estornoService;
	
	@Autowired
	private TransacaoFactory transacaoFactory;
	
	@MockBean
	OperacaoDao operacaoDao;
	
	@MockBean
	TransacaoDao transacaoDao;
	
	@MockBean
	ContasDao contaDao;
	
	@MockBean
	SaldoDao saldoDao;
	
	@Test @Ignore
	public void transferenciaTest() throws RegrasNegocioException{
		Conta contaPaiMatriz = this.criarConta(3L);
		Conta contaOrigem = this.criarConta(1L);
		contaOrigem.setNome("111");
		contaOrigem.setSaldos(Arrays.asList(this.criaSaldo(contaOrigem.getId(), 1L, 1000.00)));
		contaOrigem.setContaPaiMatriz(contaPaiMatriz);
		contaOrigem.setContaPai(contaPaiMatriz);
		when(this.contaDao.encontrarContaPeloNome(contaOrigem.getNome())).thenReturn( contaOrigem );
		
		Conta contaDestino = this.criarConta(2L);
		contaDestino.setNome("112");
		contaDestino.setSaldos(Arrays.asList(this.criaSaldo(contaDestino.getId(), 1L, 500.00)));
		contaDestino.setContaPaiMatriz(contaPaiMatriz);
		contaDestino.setContaPai(contaPaiMatriz);
		when(this.contaDao.encontrarContaPeloNome(contaDestino.getNome())).thenReturn( contaDestino );
		
		Transacao transacao = transacaoFactory.create(createTransferenciaRequest());
		transferenciaService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	@Test
	public void aporteTest() throws RegrasNegocioException{
		Conta conta = this.criarConta(1);
		conta.setSaldos(Arrays.asList(this.criaSaldo(conta.getId(), 1L, 500.00)));
		when(this.contaDao.encontrarContaPeloNome(anyString())).thenReturn( conta );
		doNothing().when(this.saldoDao).inserir(any(Saldo.class));
		when(this.transacaoDao.inserirTransacao(any(Transacao.class))).thenReturn(1L);
		
		Transacao transacao = transacaoFactory.create(createAporteRequest());
		aporteService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprocado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	@Test @Ignore
	public void estornoAporteTest() throws RegrasNegocioException{
		Long transacaoId = 1L;
		when(this.transacaoDao.encontrarTransacaoCodigoAporte(anyString())).thenReturn(new Transacao(transacaoId, null, null, "e25fe2f1e40a74c43a09bf2937611ab4", new Date()));
	
		when(this.operacaoDao.encontrarOperacaoPorTransacaoId(anyLong())).thenReturn(this.criarOperationList(transacaoId));
		
		Conta contaOrigem = this.criarConta(1L);
		Saldo saldoOrigem = this.criaSaldo(contaOrigem.getId(), 1L, 0.0);
		contaOrigem.setSaldos(Arrays.asList(saldoOrigem));
		when(this.contaDao.encontrarContaPeloId(contaOrigem.getId())).thenReturn(contaOrigem);
		
		Conta contaDestino = this.criarConta(2L);
		Saldo saldoDestino = this.criaSaldo(contaDestino.getId(), 2L,500.0);
		contaDestino.setSaldos(Arrays.asList(saldoDestino));
		when(this.contaDao.encontrarContaPeloId(contaDestino.getId())).thenReturn(contaDestino);
		
		when(operacaoDao.inserirOperacao(any(Transacao.class), any(Transferencia.class) )).thenReturn(transacaoId);
		Transacao transacao = transacaoFactory.create(createEstornoTransferenciaRequest());
		estornoService.execute(transacao);
		assertEquals("Status da transferencia deveria ter sido aprovado.",StatusOperacao.APROVADO, transacao.getOperacao().getStatus()); 
	}
	
	private Saldo criaSaldo(Long contaId,Long saldoId, double valor) {
		Saldo saldo = new Saldo();
		saldo.setContaId(contaId);
		saldo.setDataAtualizacao(new Date());
		saldo.setId(saldoId);
		saldo.setValor(valor);
		return saldo;
	}

	private Conta criarConta(long contaId) {
		Conta conta = new Conta(contaId);
		conta.setNome("123456");
		conta.setDataCriacao(new Date());
		conta.setPessoa(new PessoaFisica());
		conta.setStatusConta(StatusConta.ATIVA);
		return conta;
	}

	private List<Operacao> criarOperationList(Long transacaoId) {
		return Arrays.asList(new Transferencia(1L, 500.0, new Date(), StatusOperacao.APROVADO, TipoOperacao.TRANSFERENCIA, new Conta(1), new Conta(2)));
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
