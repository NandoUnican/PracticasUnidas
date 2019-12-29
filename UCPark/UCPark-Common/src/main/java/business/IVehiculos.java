package business;

import javax.ejb.Remote;

import dominio.Vehiculo;

@Remote
public interface IVehiculos {
	
	public boolean registraVehiculo(String matricula);
	public boolean eliminarVehiculo(String matricula);
	
}
