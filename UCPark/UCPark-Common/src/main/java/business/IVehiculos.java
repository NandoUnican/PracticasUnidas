package business;

import javax.ejb.Remote;

import dominio.Vehiculo;

@Remote
public interface IVehiculos {
	
	public Vehiculo registraVehiculo(Vehiculo v);
	public Vehiculo eliminarVehiculo(Vehiculo v);
	
}
