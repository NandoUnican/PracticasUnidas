package business;

import javax.ejb.Remote;

import dominio.Usuario;

@Remote
public interface IUsuarios {
	
	public Usuario getUsuario(long id);
	
}
