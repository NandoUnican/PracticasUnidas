package es.unican.ps.impuestoCirculacion.businessLayer;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class PlantillaIT {
	
	// Rellenar con el Path adonde guardéis el fichero ayuntamiento.xml
	private static final String DATOS_AYUNTAMIENTO = "";
	
	private static final String DATOS_BACKUP = "";
	
	
	@BeforeClass
	public static void init(){
		backup(DATOS_AYUNTAMIENTO, DATOS_BACKUP);
	}
	
	@AfterClass
	public static void end(){
		backup(DATOS_BACKUP, DATOS_AYUNTAMIENTO);
		File f = new File(DATOS_BACKUP);
		f.delete();
	}

	/**
	 * example
	 */
	@Test
	public void example(){
		
		assertTrue(true);

	}
	
	private static void backup(String filePath, String backupFilePath) {
		Path sourceFile = Paths.get(filePath);
		Path targetFile = Paths.get(backupFilePath);
		
		try {
			Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
