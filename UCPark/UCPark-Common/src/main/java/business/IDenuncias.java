package business;

import java.util.List;

import javax.ejb.Remote;

import dominio.Denuncia;

@Remote
public interface IDenuncias {
	
	public List<Denuncia> consultaDenuncias();
	public boolean denunciar(Denuncia d);
	
}
