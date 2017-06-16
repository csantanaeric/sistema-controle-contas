package br.com.hubfintech.controlecontas.controller.facotories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.daos.ContasDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.StatusOperacao;
import br.com.hubfintech.controlecontas.transacao.TipoOperacao;
import br.com.hubfintech.controlecontas.transacao.Transacao;
import br.com.hubfintech.controlecontas.transacao.Transferencia;

/**
 * 
 * @author eric
 *
 */
@Component
public class TransacaoFactory {
	
	@Autowired
	private ContasDao contaDao;
	
	@Autowired
	private TransacaoDao transacaoDao;

	public  Transacao create(Request request) {
		Transacao transacao = new Transacao();
		if(request instanceof TransferenciaRequest){
			TransferenciaRequest tranferenciaRequest = (TransferenciaRequest) request;
			Transferencia transferencia = new Transferencia();
			transferencia.setValor(Double.parseDouble(tranferenciaRequest.getValor()));
			Conta contaOrigem = contaDao.encontrarContaPeloNome(tranferenciaRequest.getContaOrigem()); 
			Conta contaDestino = contaDao.encontrarContaPeloNome(tranferenciaRequest.getContaDestino());
			transferencia.setContaOrigem(contaOrigem);
			transferencia.setContaDestino(contaDestino);
			transferencia.setStatus(StatusOperacao.APROVADO);
			transferencia.setTipoOperacao(TipoOperacao.TRANSFERENCIA);
			transacao.setOperacao(transferencia);
		} else if (request instanceof AporteRequest){
			AporteRequest aporteRequest = (AporteRequest) request;
			Aporte aporte = new Aporte();
			aporte.setTipoOperacao(TipoOperacao.APORTE);
			aporte.setValor(Double.parseDouble(aporteRequest.getValor()));
			aporte.setStatus(StatusOperacao.APROVADO);
			Conta conta = contaDao.encontrarContaPeloNome(aporteRequest.getContaBeneficiada());
			aporte.setContaDestino(conta);
			transacao.setOperacao(aporte);
		 } else if (request instanceof EstornoRequest){
			 EstornoRequest estornoResquest = (EstornoRequest) request;
			 transacao =  transacaoDao.encontrarTransacaoPeloId(estornoResquest.getTransacaoId());
			 Estorno estorno = new Estorno();
			 estorno.setTipoOperacao(TipoOperacao.ESTORNO);
			 estorno.setValor(Double.parseDouble(estornoResquest.getValor()));
			 estorno.setStatus(StatusOperacao.APROVADO);
			 transacao.setEstorno(estorno);
		 }
		return transacao;
	}

}
