/**
 * 
 */
package br.com.hubfintech.controlecontas.transacao;

/**
 * @author eric
 *
 */
public enum TipoOperacao {
	
	TRANSFERENCIA(0),APORTE(1),ESTORNO(2);
	
	private int codigoTipoOpercao;

	private TipoOperacao(int codigoTipoOpercao) {
		this.setCodigoTipoOpercao(codigoTipoOpercao);
	}

	/**
	 * Pega o tipo de operação a partir do valor.
	 * @param cdTipoOpercao
	 * @return
	 */
	public static TipoOperacao getTipoOperacao(int cdTipoOpercao){
		 for (TipoOperacao tipoOperacao : TipoOperacao.values()) {
		      if (tipoOperacao.getCodigoTipoOpercao() == cdTipoOpercao) {
		        return tipoOperacao;
		      }
		    }
		    return null;
	}

	/**
	 * @return the codigoTipoOpercao
	 */
	public int getCodigoTipoOpercao() {
		return codigoTipoOpercao;
	}

	/**
	 * @param codigoTipoOpercao the codigoTipoOpercao to set
	 */
	public void setCodigoTipoOpercao(int codigoTipoOpercao) {
		this.codigoTipoOpercao = codigoTipoOpercao;
	}	

}
