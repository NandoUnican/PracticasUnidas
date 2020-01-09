package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.IUsuariosDAO;
import dominio.Usuario;

@Stateless
public class GestionUsuario implements IRegistro, IUsuarios{
	
	@EJB
	private IUsuariosDAO usuariosDAO;
	
	public Usuario getUsuario(long id) {
		return usuariosDAO.usuarioPorId(id);
	}

	public Usuario registraUsuario(Usuario usuario) {
		return usuariosDAO.creaUsuario(usuario);
	}

}
