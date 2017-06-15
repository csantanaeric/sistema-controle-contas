/**
 * 
 */
package br.com.hubfintech.utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hubfintech.controlecontas.contas.Saldo;
import br.com.hubfintech.controlecontas.contas.StatusConta;

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
			saldo = saldos.stream().sorted(Comparator.comparing(Saldo::getDataAtualizacao).reversed())
					.collect(Collectors.toList()).get(0);
		}
		return saldo; 
	}

}
