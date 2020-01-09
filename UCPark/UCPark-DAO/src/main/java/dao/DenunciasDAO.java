package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Denuncia;

@Stateless
public class DenunciasDAO implements IDenunciasDAO{

	@PersistenceContext(unitName="UCPark")
	private EntityManager em;
	
	public List<Denuncia> denuncias() {
		Query getListaDenuncias=em.createQuery("Select d FROM Denuncia d");
		@SuppressWarnings("unchecked")
		List<Denuncia> denuncias = getListaDenuncias.getResultList();
		return denuncias;
	}

	public Denuncia denunciaPorId(long id) {
		Query getDenunciaPorId=em.createQuery("Select d FROM Denuncia d WHERE d.id = :id");
		getDenunciaPorId.setParameter("id", id);
		Denuncia denuncia= (Denuncia) getDenunciaPorId.getSingleResult();
		return denuncia;
	}

	public Denuncia creaDenuncia(Denuncia denuncia) {
		try {
			em.persist(denuncia);
		}catch (EntityExistsException e) {
			return null;
		}
		return denuncia;
	}

	public Denuncia actualizaDenuncia(Denuncia denuncia) {
		em.merge(denuncia);
		return denuncia;
	}

	public Denuncia eliminaDenuncia(long id) {
		Denuncia d=em.find(Denuncia.class, id);
		if(d==null) {
			return null;
		}else {
			em.remove(d);
			return d;
		}
	}

}
