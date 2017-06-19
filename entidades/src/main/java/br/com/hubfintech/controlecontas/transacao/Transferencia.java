/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

import java.util.Date;

import br.com.hubfintech.controlecontas.contas.Conta;

/**
 * Operacao de Tranferencia
 * @author Eric
 *
 */
public class Transferencia extends Operacao {

	public Transferencia() {
		super();
	}

	public Transferencia(Long id, double valor, Date dataOpercao, StatusOperacao status, TipoOperacao tipoOperacao,
			Conta contaOrigem, Conta contaDestino) {
		super(id, valor, dataOpercao, status, tipoOperacao, contaOrigem, contaDestino);
	}
	
}
