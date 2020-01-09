package business;

import java.util.List;

import javax.ejb.EJB;

import dao.IEstacionamientosDAO;
import dao.IVehiculosDAO;
import dominio.Estacionamiento;

public class GestionEstacionamiento implements IEstacionamiento{
	
	@EJB
	private IVehiculosDAO vehiculosDAO;
	@EJB
	private IEstacionamientosDAO estacionamientosDAO;

	public Estacionamiento registraEstacionamiento(Estacionamiento e) {
		// Se actualiza el vehiculo que tiene asignado el estacionamiento en local y luego se actualiza la dao
		e.getVehiculo().setEstacionamientoEnVigor(e);
		vehiculosDAO.actualizaVehiculo(e.getVehiculo());
		return estacionamientosDAO.creaEstacionamiento(e);
	}

	public Estacionamiento ampliaTiempoEstacionamiento(Estacionamiento e) {
		// Se actualiza el vehiculo que tiene asignado el estacionamiento en local y luego se actualiza la dao
		e.getVehiculo().setEstacionamientoEnVigor(e);
		vehiculosDAO.actualizaVehiculo(e.getVehiculo());
		return estacionamientosDAO.actualizaEstacionamiento(e);
	}

	public Estacionamiento cancelaEstacionamiento(Estacionamiento e) {
		// Se actualiza el vehiculo que tiene asignado el estacionamiento en local y luego se actualiza la dao
		e.getVehiculo().setEstacionamientoEnVigor(null);
		vehiculosDAO.actualizaVehiculo(e.getVehiculo());
		e.setFinalizado(true);// Esto es de ayuda para distinguir entre los estacionamientos finalizados
		// y los que no
		return estacionamientosDAO.eliminaEstacionamiento(e.getId());
	}

	public List<Estacionamiento> consultaEstacionamientosVigor() {
		return estacionamientosDAO.estacionamientosEnVigor();
	}

	public List<Estacionamiento> consultaHistoricoEstacionamientos() {
		return estacionamientosDAO.estacionamientos();
	}

}
