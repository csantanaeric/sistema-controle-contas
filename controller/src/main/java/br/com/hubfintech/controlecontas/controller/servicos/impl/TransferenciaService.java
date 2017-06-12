/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.servicos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.hubfintech.controlecontas.controller.dto.Request;
import br.com.hubfintech.controlecontas.controller.dto.TransferenciaRequest;
import br.com.hubfintech.controlecontas.controller.regras.RegrasNegocioException;
import br.com.hubfintech.controlecontas.controller.regras.RegrasTransacao;
import br.com.hubfintech.controlecontas.controller.regras.impl.RegrasDeTransferencia;
import br.com.hubfintech.controlecontas.controller.servicos.OperacaoService;
import br.com.hubfintech.controlecontas.transacao.Transacao;

/**
 * Executa as regras de negocio da operacao de tranferencia
 * @author Eric
 *
 */
@Service
public class TransferenciaService implements OperacaoService {
	
	
	
	//private List<RegrasTransacao> regras;
	@Autowired
	@Qualifier("regrasDeTransferencia")
	private RegrasDeTransferencia regra;

	/* (non-Javadoc)
	 * @see br.com.hubfintech.controlecontas.controller.servicos.Service#execute(br.com.hubfintech.controlecontas.transacao.Transacao)
	 */
	@Override
	public Transacao execute(Transacao transacao) throws RegrasNegocioException {
		try {
			//for(RegrasTransacao regra : regras){
				regra.validar(transacao);
			//}
		} catch (RegrasNegocioException e) {
			throw e;
		}
		return transacao;
	}

	@Override
	public boolean isOperacaoCorrente(Request request) {
		return request instanceof TransferenciaRequest;
	}

}
