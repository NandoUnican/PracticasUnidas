package es.unican.ps.impuestoCirculacion.daoLayer;

import java.util.List;

import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

/**
 * Interfaz DAO para los veh�culos
 */
public interface IVehiculosDAO  {
	/** 
	 * Persite un nuevo vehiculo
	 * @param v Vehiculo a a�adir
	 * @return El vehiculo una vez a�adido
	 */
	public Vehiculo creaVehiculo(Vehiculo v);
	
	/**
	 * Elimina el veh�culo cuya matr�cula se pasa
	 * como par�metro
	 * @param matricula
	 * @return El veh�culo eliminado
	 */
	public Vehiculo eliminaVehiculo(String matricula);
	
	/**
	 * Actualiza el estado del veh�culo que se pasa
	 * como par�metro
	 * @param nuevo Nuevo estado del vehiculo
	 * @return El vehiculo actualizado
	 */
	public Vehiculo actualizaVehiculo(Vehiculo nuevo);
	
	/**
	 * Retorna el veh�cula cuya matr�cula se pasa 
	 * como par�metro
	 * @param matricula
	 * @return El vehiculo
	 * 			null si no se encuentra
	 */
	public Vehiculo vehiculo(String matricula);
	
	/**
	 * Retorna la lista completa de veh�culos
	 * @return La lista de veh�culos
	 *         Lista vac�a si no hay ninguno
	 */
	public List<Vehiculo> vehiculos();
}
