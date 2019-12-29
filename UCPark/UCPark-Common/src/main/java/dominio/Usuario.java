package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable{
	private long id;
	private String nombre;
	private String email;
	private String contraseña;
	private List<MetodoPago> metodosPago;
	private List<Vehiculo> vehiculos;
	private List<Denuncia> denunciasEnVigor;
	
	public Usuario(String nombre, String email, String contraseña) {
		this.nombre=nombre;
		this.email=email;
		this.contraseña=contraseña;
		this.metodosPago=new ArrayList<MetodoPago>();
		this.vehiculos=new ArrayList<Vehiculo>();
		this.denunciasEnVigor=new ArrayList<Denuncia>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public List<Denuncia> getDenunciasEnVigor() {
		return denunciasEnVigor;
	}
	
	public void setDenunciasEnVigor(List<Denuncia> denuncias) {
		this.denunciasEnVigor=denuncias;
	}
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public void setVehiculo(List<Vehiculo> vehiculos) {
		this.vehiculos=vehiculos;
	}
	
	public List<MetodoPago> getMetodosPago() {
		return metodosPago;
	}
	
	public void setMestodosPago(List<MetodoPago> metodosPago) {
		this.metodosPago=metodosPago;
	}
}
