package business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.IDenunciasDAO;
import dao.IUsuariosDAO;
import dao.IVehiculosDAO;
import dominio.Denuncia;
import dominio.Usuario;
import dominio.Vehiculo;

@Stateless
public class GestionDenuncias implements IDenuncias{
	@EJB
	private IDenunciasDAO denunciasDAO;
	@EJB
	private IVehiculosDAO vehiculosDAO;
	@EJB
	private IUsuariosDAO usuariosDAO;

	public List<Denuncia> consultaDenuncias(int idUsuario) {
		return usuariosDAO.usuarioPorId(idUsuario).getDenunciasEnVigor();
	}

	public Denuncia denunciar(Denuncia d) {
		Usuario u = d.getUsuario();
		u.getDenunciasEnVigor().add(d);
		Vehiculo v = d.getVehiculoDenunciado();
		v.getDenuncias().add(d);
		usuariosDAO.actualizaUsuario(u);
		vehiculosDAO.actualizaVehiculo(v);
		return denunciasDAO.creaDenuncia(d);
	}

	public Denuncia anularDenuncia(Denuncia d) {
		Usuario u = d.getUsuario();
		u.getDenunciasEnVigor().remove(d);
		Vehiculo v = d.getVehiculoDenunciado();
		v.getDenuncias().remove(d);
		usuariosDAO.actualizaUsuario(u);
		vehiculosDAO.actualizaVehiculo(v);
		return denunciasDAO.eliminaDenuncia(d.getId());
	}

}
