package br.com.hubfintech.controlecontas.controller.facotories;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.controlecontas.contas.Conta;
import br.com.hubfintech.controlecontas.controller.dto.AporteRequest;
import br.com.hubfintech.controlecontas.controller.dto.EstornoRequest;
import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.daos.ContasDao;
import br.com.hubfintech.controlecontas.daos.OperacaoDao;
import br.com.hubfintech.controlecontas.daos.TransacaoDao;
import br.com.hubfintech.controlecontas.transacao.Aporte;
import br.com.hubfintech.controlecontas.transacao.Estorno;
import br.com.hubfintech.controlecontas.transacao.Operacao;
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
	
	@Autowired
	private OperacaoDao operacaoDao;

	public  Transacao create(Request request)  {
		Transacao transacao = new Transacao();
		if(request instanceof TransferenciaRequest){
			TransferenciaRequest tranferenciaRequest = (TransferenciaRequest) request;
			Transferencia transferencia = new Transferencia();
			transferencia.setValor(Double.parseDouble(tranferenciaRequest.getValor()));
			Conta contaOrigem = contaDao.encontrarContaPeloNome(tranferenciaRequest.getContaOrigem()); 
			Conta contaDestino = contaDao.encontrarContaPeloNome(tranferenciaRequest.getContaDestino());
			transferencia.setContaOrigem(contaOrigem);
			transferencia.setContaDestino(contaDestino);
			transferencia.setStatus(StatusOperacao.EXECUTANDO);
			transferencia.setTipoOperacao(TipoOperacao.TRANSFERENCIA);
			transferencia.setDataOpercao(new Date());
			transacao.setOperacao(transferencia);
		} else if (request instanceof AporteRequest){
			AporteRequest aporteRequest = (AporteRequest) request;
			Aporte aporte = new Aporte();
			aporte.setTipoOperacao(TipoOperacao.APORTE);
			aporte.setValor(Double.parseDouble(aporteRequest.getValor()));
			aporte.setStatus(StatusOperacao.EXECUTANDO);
			Conta conta = contaDao.encontrarContaPeloNome(aporteRequest.getContaBeneficiada());
			aporte.setContaDestino(conta);
			aporte.setDataOpercao(new Date());
			transacao.setOperacao(aporte);
		 } else if (request instanceof EstornoRequest){
			 EstornoRequest estornoResquest = (EstornoRequest) request;
			 final Transacao transacaoEstorno =  transacaoDao.encontrarTransacaoCodigoAporte(estornoResquest.getCodigoAporte());
			 if(transacaoEstorno == null){
				 return null;
			 }
			operacaoDao.encontrarOperacaoPorTransacaoId(transacaoEstorno.getTransacaoId()).forEach(o -> this.popularOperacaoEstorno(o, transacaoEstorno));
			if(transacaoEstorno.getEstorno() == null){
				 Estorno estorno = new Estorno();
				 estorno.setTipoOperacao(TipoOperacao.ESTORNO);
				 estorno.setValor(Double.parseDouble(estornoResquest.getValor()));
				 estorno.setStatus(StatusOperacao.EXECUTANDO);
				 estorno.setDataOpercao(new Date());
				 transacaoEstorno.setEstorno(estorno);
			}
			transacao = transacaoEstorno;
		 }
		return transacao;
	}
	public void popularOperacaoEstorno(Operacao o,final Transacao transacao ){
		if(TipoOperacao.ESTORNO.equals(o.getTipoOperacao())){
			transacao.setEstorno((Estorno)o);
		} else {
			 o.setContaDestino(contaDao.encontrarContaPeloId(o.getContaDestino() == null ? null : o.getContaDestino().getId()));
			 o.setContaOrigem(contaDao.encontrarContaPeloId(o.getContaOrigem() == null ? null : o.getContaOrigem().getId()));
			 transacao.setOperacao(o);
		}
		
	}

}
