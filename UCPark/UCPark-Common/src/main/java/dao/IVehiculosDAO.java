package dao;

import java.util.List;

import javax.ejb.Remote;

import dominio.Vehiculo;

@Remote
public interface IVehiculosDAO {
	
	public List<Vehiculo> vehiculos();
	public Vehiculo usuarioPorId(long id);
	public Vehiculo usuarioPorMatricula(String matricula);
	public Vehiculo creaVehiculo(Vehiculo vehiculo);
	public Vehiculo actualizaVehiculo(Vehiculo vehiculo);
	public Vehiculo eliminaVehiculo(Vehiculo vehiculo);
	
}
