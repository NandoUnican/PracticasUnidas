package es.unican.ps.impuestoCirculacion.businessLayer;



import es.unican.ps.impuestoCirculacion.domain.Vehiculo;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;

/**
 * Interfaz de negocio para gestionar vehiculos
 */
public interface IGestionVehiculos {
	
	/**
	 * A�ade un nuevo vehiculo al contribuyente cuyo dni se pasa
	 * como par�metro.
	 * @param a Vehiculo que desea a�adir
	 * @param dni DNI del contribuyente al que se le quiere a�adir
	 * @return El veh�culo a�adido
	 * 		   null si no se a�ade porque no se encuentra el contribuyente
	 * @throws OperacionNoValida si el contribuyente ya tiene ese coche
	 */
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida;
	
	/**
	 * Elimina el veh�culo cuya matr�cula se pasa como par�metro y 
	 * que pertenece al contribuyente cuyo dni se pasa como par�metro
	 * @param matricula Matricula del coche a eliminar
	 * @param dni DNI del propietario del veh�culo
 	 * @return El veh�culo eliminado
 	 *         null si el veh�culo o el propietario no existen
 	 * @throws OperacionNoValida si el veh�culo no pertenece al dni indicado
	 */
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida;
	
	/**
	 * Retorna el veh�culo cuya matr�cula se pasa como par�metro
	 * @param matricula 
	 * @return El veh�culo
	 * 	       null si no existe
	 */
	public Vehiculo vehiculo(String matricula); 	

}
