package businessTest;
import org.junit.BeforeClass;
import org.junit.Test;

import business.GestionEstacionamiento;
import dao.IEstacionamientosDAO;
import dao.IVehiculosDAO;
import dominio.Estacionamiento;
import dominio.Vehiculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.resource.ResourceException;
public class GestionEstacionamientoTest {
	
	private static GestionEstacionamiento ge;
	private static IEstacionamientosDAO estacionamientoDAO;
	private static IVehiculosDAO vehiculoDAO;

	@BeforeClass
	public static void setUp() {
		ge = new GestionEstacionamiento();
		estacionamientoDAO = mock(IEstacionamientosDAO.class);
		vehiculoDAO = mock(IVehiculosDAO.class);
		ge.setEstacionamientoDAO(estacionamientoDAO);
		ge.setVehiculoDAO(vehiculoDAO);
	}
	
	@Test
	public void testU1a() {
		Vehiculo v = new Vehiculo();
		Estacionamiento es = new Estacionamiento();
		Estacionamiento result;
		es.setId(1);
		es.setMinutos(60);
		v.setMatricula("7777 BBB");
		es.setVehiculo(v);
		when(vehiculoDAO.vehiculoPorMatricula("7777 BBB")).thenReturn(v);
		when(estacionamientoDAO.creaEstacionamiento(es)).thenReturn(es);
		try {
			result = ge.registraEstacionamiento(es);
			assertTrue(es.equals(result));
		}catch(ResourceException e) {
			fail("No deberia saltar excepcion");
		}
	}
	
	@Test
	public void testU2a() {
		Vehiculo v = new Vehiculo();
		Estacionamiento es = new Estacionamiento();
		Estacionamiento esPrevio = new Estacionamiento();
		Estacionamiento result;
		es.setId(2);
		es.setMinutos(60);
		v.setMatricula("7777 AAA");
		v.setEstacionamientoEnVigor(esPrevio);
		es.setVehiculo(v);
		when(vehiculoDAO.vehiculoPorMatricula("7777 AAA")).thenReturn(v);
		when(estacionamientoDAO.creaEstacionamiento(es)).thenReturn(es);
		try {
			result = ge.registraEstacionamiento(es);
			fail("Deberia saltar excepcion");
		}catch(ResourceException e) {
			
		}
	}
	
	@Test
	public void testU3a() {
		Vehiculo v = new Vehiculo();
		Estacionamiento es = new Estacionamiento();
		Estacionamiento result;
		es.setId(2);
		es.setMinutos(125);
		v.setMatricula("7777 BBB");
		es.setVehiculo(v);
		when(vehiculoDAO.vehiculoPorMatricula("7777 BBB")).thenReturn(v);
		when(estacionamientoDAO.creaEstacionamiento(es)).thenReturn(es);
		try {
			result = ge.registraEstacionamiento(es);
			fail("Deberia saltar excepcion");
		}catch(ResourceException e) {
			
		}
	}
	
	@Test
	public void testU4a() {
		Vehiculo v = new Vehiculo();
		Estacionamiento es = new Estacionamiento();
		Estacionamiento result;
		es.setId(2);
		es.setMinutos(125);
		v.setMatricula("7777 BBB");
		es.setVehiculo(v);
		when(vehiculoDAO.vehiculoPorMatricula("1234 BBB")).thenReturn(v);
		when(estacionamientoDAO.creaEstacionamiento(es)).thenReturn(es);
		try {
			result = ge.registraEstacionamiento(es);
			fail("Deberia saltar excepcion");
		}catch(ResourceException e) {
			
		}
	}
}
