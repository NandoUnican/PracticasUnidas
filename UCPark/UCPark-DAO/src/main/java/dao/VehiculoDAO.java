package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Vehiculo;

@Stateless
public class VehiculoDAO implements IVehiculosDAO {
	
	@PersistenceContext(unitName="UCPark")
	private EntityManager em;

	public List<Vehiculo> vehiculos() {
		Query getListaVehiculos=em.createQuery("Select v FROM Vehiculos v");
		@SuppressWarnings("unchecked")
		List<Vehiculo> vehiculos = getListaVehiculos.getResultList();
		return vehiculos;
	}

	public Vehiculo vehiculoPorId(long id) {
		Query getVehiculoPorId=em.createQuery("Select v FROM Vehiculo v WHERE e.id = :id");
		getVehiculoPorId.setParameter("id", id);
		Vehiculo vehiculo= (Vehiculo) getVehiculoPorId.getSingleResult();
		return vehiculo;
	}

	public Vehiculo vehiculoPorMatricula(String matricula) {
		Query getVehiculoPorId=em.createQuery("Select v FROM Vehiculo v WHERE e.matricula = :matricula");
		getVehiculoPorId.setParameter("matricula", matricula);
		Vehiculo vehiculo= (Vehiculo) getVehiculoPorId.getSingleResult();
		return vehiculo;
	}

	public Vehiculo creaVehiculo(Vehiculo vehiculo) {
		try {
			em.persist(vehiculo);
		}catch (EntityExistsException e) {
			return null;
		}
		return vehiculo;
	}

	public Vehiculo actualizaVehiculo(Vehiculo vehiculo) {
		em.merge(vehiculo);
		return vehiculo;
	}

	public Vehiculo eliminaVehiculo(long id) {
		Vehiculo v=em.find(Vehiculo.class, id);
		if(v==null) {
			return null;
		}else {
			em.remove(v);
			return v;
		}
	}
	
	public void setEntityManager(EntityManager em) {
		this.em=em;
	}

}
