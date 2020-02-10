package es.unican.ps.impuestoCirculacion.daoLayer;

import java.util.LinkedList;
import java.util.List;

import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

public class ImpuestosDAO implements IContribuyentesDAO, IVehiculosDAO {
	
	private Ayuntamiento ayun;
	
	public ImpuestosDAO() {
		ayun = Ayuntamiento.creaAyuntamiento();
	}

	
	// Interfaz IContribuyentesDAO
	@Override
	public Contribuyente creaContribuyente(Contribuyente c) {
		if (contribuyente(c.getDni())!= null)
			return null;
		ayun.getContribuyentes().add(c);
		Ayuntamiento.flush(ayun);
		return contribuyente(c.getDni());
	}

	@Override
	public Contribuyente contribuyente(String dni) {
		for (Contribuyente c: ayun.getContribuyentes()) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Contribuyente actualizaContribuyente(Contribuyente nuevo) {
		if (contribuyente(nuevo.getDni())!= null) {
			ayun.getContribuyentes().remove(nuevo);
			ayun.getContribuyentes().add(nuevo);
			Ayuntamiento.flush(ayun);
			return nuevo;
		}
		return null;
	}

	@Override
	public Contribuyente eliminaContribuyente(String dni) {
		Contribuyente c = contribuyente(dni);
		if (c!=null) {
			ayun.getContribuyentes().remove(c);
			Ayuntamiento.flush(ayun);
			return c;
		}
		return null;
	}

	@Override
	public List<Contribuyente> contribuyentes() {
		return ayun.getContribuyentes();
	}


	// Interfaz IVehiculosDAO
	@Override
	public Vehiculo creaVehiculo(Vehiculo v) {	
		return vehiculo(v.getMatricula());
	}

	@Override
	public Vehiculo eliminaVehiculo(String matricula) {  
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v : c.getVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					c.getVehiculos().remove(v);
					Ayuntamiento.flush(ayun);
					return v;
				}
				
			}
		}
		return null;
	}

	@Override
	public Vehiculo actualizaVehiculo(Vehiculo nuevo) {   
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v: c.getVehiculos()) {
				if (v.getMatricula().equals(nuevo.getMatricula())) {
					Ayuntamiento.flush(ayun);
					return v;
				}
			}
		}
		return null;
	}

	@Override
	public Vehiculo vehiculo(String matricula) {
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v: c.getVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					return v;
				}
			}
		}
		return null;
	}

	@Override
	public List<Vehiculo> vehiculos() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		for (Contribuyente c:ayun.getContribuyentes()) {
			vehiculos.addAll(c.getVehiculos());
		}
		return vehiculos;
	}


}
