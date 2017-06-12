package br.com.hubfintech.controlecontas.controller.facotories;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.ContaFilial;
import br.com.hubfintech.controlecontas.contas.ContaMatriz;
import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

@Component
public class TransacaoFactory {

	public  Transacao create(Request request) {
		Transacao transacao = new Transacao();
		if(request instanceof TransferenciaRequest){
			TransferenciaRequest tranferenciaRequest = (TransferenciaRequest) request;
			Transferencia transferencia = new Transferencia();
			transferencia.setValor(Double.parseDouble(tranferenciaRequest.getValor()));
			transferencia.setContaOrigem(new ContaFilial(new ContaMatriz()));
			transferencia.setContaDestino(new ContaFilial(transferencia.getContaOrigem()));
			transferencia.setStatus(StatusOperacao.OK);
			transacao.setOperacao(transferencia);
		} else if (request instanceof AporteRequest){
			AporteRequest aporteRequest = (AporteRequest) request;
			Aporte aporte = new Aporte();
			aporte.setValor(Double.parseDouble(aporteRequest.getValor()));
			aporte.setStatus(StatusOperacao.OK);
			ContaMatriz conta = new ContaMatriz();
			conta.setDataCriacao(new Date());
			conta.setNome(aporteRequest.getContaBeneficiada());
			aporte.setConta(conta);
			transacao.setOperacao(aporte);
		 } else if (request instanceof EstornoRequest){
			 EstornoRequest estornoResquest = (EstornoRequest) request;
			 
			 //buscar no banco a transação
			 transacao.setTransacaoId(estornoResquest.getTransacaoId());
			 transacao.setOperacao(new Transferencia());
			 Estorno estorno = new Estorno();
			 estorno.setValor(Double.parseDouble(estornoResquest.getValor()));
			 estorno.setStatus(StatusOperacao.OK);
			 transacao.setEstorno(estorno);
		 }
		
		
		return transacao;
	}

}
