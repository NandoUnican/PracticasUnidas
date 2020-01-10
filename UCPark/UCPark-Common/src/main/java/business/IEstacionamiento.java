package business;

import java.util.List;

import javax.ejb.Remote;
import javax.resource.ResourceException;

import dominio.Estacionamiento;

@Remote
public interface IEstacionamiento {
	
	public Estacionamiento registraEstacionamiento(Estacionamiento e) throws ResourceException;
	public Estacionamiento ampliaTiempoEstacionamiento(Estacionamiento e);
	public Estacionamiento cancelaEstacionamiento(Estacionamiento e);
	// Se entiende que son todos los estacionamientos, no exclusivamente los de un usuario/vehiculo
	public List<Estacionamiento> consultaEstacionamientosVigor();
	public List<Estacionamiento> consultaHistoricoEstacionamientos();
	
}
