package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.IVehiculoAgente;
import business.IVehiculos;
import dao.IUsuariosDAO;
import dao.IVehiculosDAO;
import dominio.Estacionamiento;
import dominio.Usuario;
import dominio.Vehiculo;

@Stateless
public class GestionVehiculos implements IVehiculos, IVehiculoAgente {
	
	@EJB
	private IVehiculosDAO vehiculosDAO;
	@EJB
	private IUsuariosDAO usuariosDAO;

	public Vehiculo registraVehiculo(Vehiculo v) {
		Usuario u = v.getPropietario();
		u.getVehiculos().add(v);
		usuariosDAO.actualizaUsuario(u);
		return vehiculosDAO.creaVehiculo(v);
	}

	public Vehiculo eliminarVehiculo(Vehiculo v) {
		Usuario u = v.getPropietario();
		u.getVehiculos().remove(v);
		usuariosDAO.actualizaUsuario(u);
		return vehiculosDAO.eliminaVehiculo(v.getId());
	}

	public Estacionamiento compruebaEstacionamiento(String matricula) {
		return vehiculosDAO.vehiculoPorMatricula(matricula).getEstacionamientoEnVigor();
		
	}

}
