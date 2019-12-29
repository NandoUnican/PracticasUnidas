package dao;

import java.util.List;

import javax.ejb.Remote;

import dominio.Usuario;

@Remote
public interface IUsuariosDAO {
	
	public List<Usuario> usuarios();
	public Usuario usuarioPorId(long id);
	public Usuario creaUsuario(Usuario usuario);
	public Usuario actualizaUsuario(Usuario usuario);
	public Usuario eliminaUsuario(Usuario usuario);
	
}
