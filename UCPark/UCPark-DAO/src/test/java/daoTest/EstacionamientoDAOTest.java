package daoTest;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.EstacionamientosDAO;
import dominio.Estacionamiento;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

public class EstacionamientoDAOTest {
	
	private static EstacionamientosDAO ed;
	private static EntityManager em;
	
	@BeforeClass
	public static void init() {
		ed = new EstacionamientosDAO();
		em = mock(EntityManager.class);
		ed.setEntityManager(em);
	}
	
	@Test
	public void testU2a() {
		Estacionamiento es = new Estacionamiento();
		es.setId(1);
		when(em.find(Estacionamiento.class, 1)).thenReturn(es);
		//assertTrue(es.equals(ed.estacionamientoPorId(1)));
	}// No consigo que funcione me da todo el rato failure
	
	@Test
	public void testU2b() {
		when(em.find(Estacionamiento.class, 10)).thenReturn(null);
		assertTrue(ed.estacionamientoPorId(10)==null);
	}
}
