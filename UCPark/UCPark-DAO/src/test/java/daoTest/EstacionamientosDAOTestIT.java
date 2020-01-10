package daoTest;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.IEstacionamientosDAO;
import dominio.Estacionamiento;;

public class EstacionamientosDAOTestIT {
	private static EJBContainer ec;
	private static IEstacionamientosDAO f;
	
	@BeforeClass
	public static void initContainer() throws Exception {
		Map properties = new HashMap();
		properties.put(EJBContainer.MODULES, new File[]{new File("classes")});
		properties.put("org.glassfish.ejb.embedded.glassfish.installation.root",
				"C:/Users/Nando/Downloads/Mierdas/glassfish4/glassfish");
		ec = EJBContainer.createEJBContainer(properties);
		f = (IEstacionamientosDAO) ec.getContext().lookup("java:global/UCPark-EAR-0.0.1-SNAPSHOT/UCPark-DAO-0.0.1-SNAPSHOT/EstacionamientosDAO!daoClasses.IEstacionamientosDAO");
	}
	
	@AfterClass
	public static void closeContainer() throws Exception {
		if (ec != null) {
		ec.close();
		}
	}
	
	@Test
	public void TestI2a() {
		Estacionamiento es = new Estacionamiento();
		es.setId(1);
		assertTrue(es.equals(f.estacionamientoPorId(1)));
	}
	
	@Test
	public void TestI2b() {
		assertTrue(f.estacionamientoPorId(10)==null);
	}
}
