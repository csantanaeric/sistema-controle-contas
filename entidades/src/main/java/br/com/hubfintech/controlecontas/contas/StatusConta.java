/**
 * 
 */
package br.com.hubfintech.controlecontas.contas;

/**
 * @author Eric
 *
 */
public enum StatusConta {
	
	ATIVA("A"),BLOQUEADA("B"),CANCELADA("C");
	
	private String codigoStatus;

	private StatusConta(String codigoStatus) {
		this.setCodigoStatus(codigoStatus);
	}

	/**
	 * @return the codigoStatus
	 */
	public String getCodigoStatus() {
		return codigoStatus;
	}

	/**
	 * @param codigoStatus the codigoStatus to set
	 */
	public void setCodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	
	
	public static StatusConta getStatusConta(String codigoStatusConta){
		 for (StatusConta statusConta : StatusConta.values()) {
		      if (statusConta.getCodigoStatus().equalsIgnoreCase(codigoStatusConta)) {
		        return statusConta;
		      }
		    }
		    return null;
	}
}
