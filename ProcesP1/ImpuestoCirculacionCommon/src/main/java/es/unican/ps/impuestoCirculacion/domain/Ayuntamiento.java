package es.unican.ps.impuestoCirculacion.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ayuntamiento {
	@XmlIDREF
	@XmlElement(name = "contribuyentes", type = Contribuyente.class)
	private List<Contribuyente>contribuyentes;
	
	public Ayuntamiento() {}
	
	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}
	
	public void setContribuyentes(List<Contribuyente> lista) {
		this.contribuyentes = lista;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void setVehiculos(List<Vehiculo> lista) {
		this.vehiculos = lista;
	}
}
