/**
 * 
 */
package br.com.hubfintech.controlecontas.controller.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hubfintech.controlecontas.contas.Saldo;

/**
 * @author eric
 *
 */
public final class ControllerUtilitario {
	
	
	public static Saldo getSaldo(List<Saldo> saldos) {
		return saldos.stream().sorted(Comparator.comparing(Saldo::getDataAtualizacao).reversed())
				.collect(Collectors.toList()).get(0);
	}
	
	
	

}
