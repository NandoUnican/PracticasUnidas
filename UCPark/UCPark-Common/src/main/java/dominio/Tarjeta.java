package dominio;

import javax.persistence.Embeddable;

@Embeddable
public class Tarjeta extends MetodoPago{
	
	private String numero;
	private String cvc;
	private String titular;
	
	public Tarjeta(String numero, String cvc, String titular) {
		this.numero=numero;
		this.cvc=cvc;
		this.titular=titular;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero=numero;
	}
	
	public String getCvc() {
		return cvc;
	}
	
	public void setCvc(String cvc) {
		this.cvc=cvc;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular=titular;
	}
	
	// Constructor vacio
	public Tarjeta() {}
}
