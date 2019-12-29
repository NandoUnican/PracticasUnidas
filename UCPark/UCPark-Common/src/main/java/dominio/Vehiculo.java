package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo implements Serializable {
	private long id;
	private String matricula;
	private String marca;
	private String modelo;
	private Usuario propietario;
	private Estacionamiento estacionamientoEnVigor;
	private List<Denuncia> denuncias;
	
	public Vehiculo (String matricula, String marca, String modelo) {
		// id se carga automáticamente
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
		this.estacionamientoEnVigor=null;
		this.denuncias=new ArrayList<Denuncia>();
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Usuario propietario) {
		this.propietario=propietario;
	}
	
	public Estacionamiento getEstacionamientoEnVigor() {
		return estacionamientoEnVigor;
	}
	
	public void setEstacionamientoEnVigor(Estacionamiento estacionamientoEnVigor) {
		this.estacionamientoEnVigor=estacionamientoEnVigor;
	}
	
	public List<Denuncia> getDenuncias() {
		return denuncias;
	}
	
	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias=denuncias;
	}
}
