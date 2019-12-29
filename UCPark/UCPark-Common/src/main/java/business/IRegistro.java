package business;

import javax.ejb.Remote;

import dominio.Usuario;

@Remote
public interface IRegistro {
	
	public boolean registraUsuario(Usuario usuario);
	
}
