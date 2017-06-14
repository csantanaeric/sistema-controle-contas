/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.processo.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.facotories.TransacaoFactory;
import br.com.hubfintech.controlecontas.controller.processo.Processador;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * implementação para executar os servicos
 * @author Eric
 *
 */
@Service
public class ProcessadorServico implements Processador {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessadorServico.class);
	
	@Autowired
	private TransacaoFactory transacaoFactory;
	
	@Autowired
	private List<OperacaoService> services;

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.processo.Processador#execute(br.com.hubfintech.controlecontas.controller.dto.Request)
	 */
	@Override
	public void execute(Request request, RetornoService retorno)  {
		Transacao transacao = transacaoFactory.create(request);
		OperacaoService service = this.services.stream().filter(o -> o.isOperacaoCorrente(request)).collect(Collectors.toList()).get(0);
		
		String mensagem = "Operacao efetuada com sucesso";
		try {
			service.execute(transacao);
		} catch (RegrasNegocioException e) {

			mensagem = e.getMessage();
			LOGGER.error("Operacao não realiza",e);
		}
		retorno.execute(transacao,mensagem);
	}

}
