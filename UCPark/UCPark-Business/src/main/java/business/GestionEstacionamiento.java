package business;

import java.util.List;

import javax.ejb.EJB;
import javax.resource.ResourceException;

import dao.IEstacionamientosDAO;
import dao.IVehiculosDAO;
import dominio.Estacionamiento;

public class GestionEstacionamiento implements IEstacionamiento{
	
	@EJB
	private IVehiculosDAO vehiculosDAO;
	@EJB
	private IEstacionamientosDAO estacionamientosDAO;

	public Estacionamiento registraEstacionamiento(Estacionamiento e) throws ResourceException {
		// Se actualiza el vehiculo que tiene asignado el estacionamiento en local y luego se actualiza la dao
		if(e.getMinutos()>60) {
			throw new ResourceException();
		}else if(vehiculosDAO.vehiculoPorMatricula(e.getVehiculo().getMatricula())==null
				|| vehiculosDAO.vehiculoPorMatricula(e.getVehiculo().getMatricula()).getEstacionamientoEnVigor() !=null) {
			// Comprueba que exista el vehiculo y que no tenga un estacionamiento en vigor
			throw new ResourceException();
		}
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
	
	public void setEstacionamientoDAO(IEstacionamientosDAO estacionamientosDAO) {
		this.estacionamientosDAO=estacionamientosDAO;
	}
	
	public void setVehiculoDAO(IVehiculosDAO vehiculoDAO) {
		this.vehiculosDAO=vehiculoDAO;
	}

}
