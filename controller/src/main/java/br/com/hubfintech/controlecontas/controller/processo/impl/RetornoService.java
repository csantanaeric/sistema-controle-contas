package br.com.hubfintech.controlecontas.controller.processo.impl;

import br.com.hubfintech.controlecontas.transacao.Transacao;

public interface RetornoService {
	
	public void execute(Transacao transacao);

}
