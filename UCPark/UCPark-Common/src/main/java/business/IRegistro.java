package business;

import javax.ejb.Remote;

import dominio.Usuario;

@Remote
public interface IRegistro {
	
	public Usuario registraUsuario(Usuario usuario);
	
}
