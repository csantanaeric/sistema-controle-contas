/**
 * 
 */
package br.com.hubfintech.controlecontas.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.Response;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.processo.Processador;
import br.com.hubfintech.controlecontas.transacao.Operacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Classe responsável por publicar funcionalidades do sistema de contas em forma de serviços.
 * @author Eric
 *
 */
@RestController
public class TransacaoRecurso {
	
	@Autowired
	private Processador processador;
	
	@RequestMapping(path ="/transferir", method = RequestMethod.POST)
	public ResponseEntity<Response> transferir(@RequestBody TransferenciaRequest request){
		return this.executar(request); 
	}
	
	@RequestMapping(path ="/efetuarAporte", method = RequestMethod.POST)
	public ResponseEntity<Response> efetuarAporte(@RequestBody AporteRequest request){
		return this.executar(request);
	}
	
	@RequestMapping(path ="/estornar", method = RequestMethod.POST)
	public ResponseEntity<Response> estornar(@RequestBody EstornoRequest request){
		return this.executar(request);
	}
	
	public ResponseEntity<Response> executar(Request request){
		processador.execute(request, (t, m) -> this.prepararRetorno(request,t,m) );
		return new ResponseEntity<>(request.getResponse() ,HttpStatus.OK);
	}
	
	
	public void prepararRetorno(Request request, Transacao transacao, String mensagem){
		Response response = new Response();
		if(transacao.getOperacao() != null){
			Operacao operacao = transacao.getOperacao();
			response.setStatus(operacao.getStatus().toString());
			response.setMensagem(mensagem);
			response.setValor(Double.toString(operacao.getValor()));
		}
		request.setResponse(response);
	}
	
	

}
