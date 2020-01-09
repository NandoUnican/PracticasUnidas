package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateless
public class UsuariosDAO implements IUsuariosDAO{

	@PersistenceContext(unitName="UCPark")
	private EntityManager em;
	
	public List<Usuario> usuarios() {
		Query getListaUsuarios=em.createQuery("Select u FROM Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = getListaUsuarios.getResultList();
		return usuarios;
	}

	public Usuario usuarioPorId(long id) {
		Query getUsuarioPorId=em.createQuery("Select u FROM Usuario u WHERE u.id = :id");
		getUsuarioPorId.setParameter("id", id);
		Usuario usuario= (Usuario) getUsuarioPorId.getSingleResult();
		return usuario;
	}

	public Usuario creaUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
		}catch (EntityExistsException e) {
			return null;
		}
		return usuario;
	}

	public Usuario actualizaUsuario(Usuario usuario) {
		em.merge(usuario);
		return usuario;
	}

	public Usuario eliminaUsuario(long id) {
		Usuario u=em.find(Usuario.class, id);
		if(u==null) {
			return null;
		}else {
			em.remove(u);
			return u;
		}
	}

}
