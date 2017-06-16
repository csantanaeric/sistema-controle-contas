/**
 * 
 */
package br.com.hubfintech.utils;

import java.util.List;

import br.com.hubfintech.controlecontas.contas.Saldo;

/**
 * @author Eric
 *
 */
public  class ContasUtils {
	
	private ContasUtils(){
		
	}
	
	public static Saldo getSaldo(List<Saldo> saldos) {
		Saldo saldo = null;
		if(saldos!=null){
			saldos.sort((Saldo s1, Saldo s2) ->  s2.getDataAtualizacao().compareTo(s1.getDataAtualizacao()));
			saldo =saldos.get(0);
		}
		return saldo; 
	}

}
