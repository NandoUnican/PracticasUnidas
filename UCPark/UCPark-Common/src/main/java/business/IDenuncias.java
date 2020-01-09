package business;

import java.util.List;

import javax.ejb.Remote;

import dominio.Denuncia;

@Remote
public interface IDenuncias {
	
	public List<Denuncia> consultaDenuncias(int idUsuario);
	public Denuncia denunciar(Denuncia d);
	public Denuncia anularDenuncia(Denuncia d);
	
}
