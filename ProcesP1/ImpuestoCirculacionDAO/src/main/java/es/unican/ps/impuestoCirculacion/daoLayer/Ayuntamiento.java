package es.unican.ps.impuestoCirculacion.daoLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.unican.ps.impuestoCirculacion.domain.Contribuyente;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ayuntamiento")
public class Ayuntamiento {
	
	// Reemplazar con el Path dónde almacenéis el fichero ayuntamiento.xml
	public static String DATA_FILE = "C:\\Users\\Administrador\\Dropbox\\Procesos\\Practicas\\Practica1\\ayuntamiento.xml";

	@XmlElement(required = true, name="contribuyente")
	private List<Contribuyente> contribuyentes;

	/**
	 * Gets the value of the contribuyente property.
	 */
	public List<Contribuyente> getContribuyentes() {
		if (contribuyentes == null) {
			contribuyentes = new ArrayList<Contribuyente>();
		}
		return this.contribuyentes;
	}
	

	/**
	 * @param contribuyente the contribuyente to set
	 */
	public void setContribuyente(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}


	public static void flush(Ayuntamiento ayun) {
		try {
			JAXBContext jaxbctx = JAXBContext.newInstance(Ayuntamiento.class);
			// Volcar la ifnoramciÃ›n a un fichero
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(ayun, new File(DATA_FILE));
		} catch (JAXBException e) {
			System.out.println("No se puede volcar la informacion al fichero");
			System.exit(0);
		}
	}

	public static Ayuntamiento creaAyuntamiento() {
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Ayuntamiento.class);
			// Procesamos el documento (Unmarshall)
			javax.xml.bind.Unmarshaller unmarshaller = jaxbctx
					.createUnmarshaller();
			return (Ayuntamiento) unmarshaller.unmarshal(new File(DATA_FILE));

		} catch (JAXBException j) {
			System.out.println("Error del JAXB");
			System.out.println(j);
		}
		return null;
	}
}
