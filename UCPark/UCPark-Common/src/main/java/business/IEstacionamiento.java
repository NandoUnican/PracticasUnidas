package business;

import java.util.List;

import javax.ejb.Remote;

import dominio.Estacionamiento;

@Remote
public interface IEstacionamiento {
	
	public boolean registraEstacionamiento(Estacionamiento e);
	public boolean ampliaTiempoEstacionamiento(Estacionamiento e);
	public boolean cancelaEstacionamiento(Estacionamiento e);
	// Se entiende que son todos los estacionamientos, no exclusivamente los de un usuario/vehiculo
	public List<Estacionamiento> consultaEstacionamientosVigor();
	public List<Estacionamiento> consultaHistoricoEstacionamientos();
	
}
