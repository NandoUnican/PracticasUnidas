package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Estacionamiento;

@Stateless
public class EstacionamientosDAO implements IEstacionamientosDAO{
	
	@PersistenceContext(unitName="UCPark")
	private EntityManager em;
	
	public List<Estacionamiento> estacionamientos() {
		Query getListaEstacionamientos=em.createQuery("Select e FROM Estacionamientos e");
		@SuppressWarnings("unchecked")
		List<Estacionamiento> estacionamientos = getListaEstacionamientos.getResultList();
		return estacionamientos;
	}

	public List<Estacionamiento> estacionamientosEnVigor() {
		Query getListaEstacionamientosVigor=em.createQuery("Select e FROM Estacionamientos e WHERE e.finalizado=true");
		@SuppressWarnings("unchecked")
		List<Estacionamiento> estacionamientos = getListaEstacionamientosVigor.getResultList();
		return estacionamientos;
	}

	public Estacionamiento estacionamientoPorId(long id) {
		/*Query getEstacionamientoPorId=em.createQuery("Select e FROM Estacionamiento e WHERE e.id = :id");
		getEstacionamientoPorId.setParameter("id", id);
		Estacionamiento estacionamiento= (Estacionamiento) getEstacionamientoPorId.getSingleResult();
		return estacionamiento;*/
		return em.find(Estacionamiento.class, id);
	}

	public Estacionamiento creaEstacionamiento(Estacionamiento estacionamiento) {
		try {
			em.persist(estacionamiento);
		}catch (EntityExistsException e) {
			return null;
		}
		return estacionamiento;
	}

	public Estacionamiento actualizaEstacionamiento(Estacionamiento estacionamiento) {
		em.merge(estacionamiento);
		return estacionamiento;
	}

	public Estacionamiento eliminaEstacionamiento(long id) {
		Estacionamiento e=em.find(Estacionamiento.class, id);
		if(e==null) {
			return null;
		}else {
			em.remove(e);
			return e;
		}
	}

	public void setEntityManager(EntityManager em) {
		this.em=em;
	}
}
