package dao;

import java.util.List;

import javax.ejb.Remote;

import dominio.Denuncia;

@Remote
public interface IDenunciasDAO {
	
	public List<Denuncia> denuncias();
	public Denuncia denunciaPorId(long id);
	public Denuncia creaDenuncia(Denuncia denuncia);
	public Denuncia actualizaDenuncia(Denuncia denuncia);
	public Denuncia eliminaDenuncia(long id);
	
}
