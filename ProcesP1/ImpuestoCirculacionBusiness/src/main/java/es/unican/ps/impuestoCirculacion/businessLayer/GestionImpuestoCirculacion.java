package es.unican.ps.impuestoCirculacion.businessLayer;



import java.util.List;

import es.unican.ps.impuestoCirculacion.daoLayer.IContribuyentesDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.IVehiculosDAO;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;



public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	@Override
	public Contribuyente altaContribuyente(Contribuyente c) {
		return contribuyentes.creaContribuyente(c);
	}

	@Override
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c.getVehiculos().size()==0)
			return contribuyentes.eliminaContribuyente(dni);
		throw new OperacionNoValida("El usuario tiene vehículos a su nombre");
	}
	
	@Override
	public double totalContribuyente(String dni) {
		double result = 1.0;
		Contribuyente c = contribuyentes.contribuyente(dni);	
		if (c!=null) {
			return c.totalAPagar();
		}
		return result;
	}
	
	@Override
	public Contribuyente contribuyente(String dni) {
		return contribuyentes.eliminaContribuyente(dni);
	}

	@Override
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c!=null) {
			List<Vehiculo> lista = c.getVehiculos();
			if (lista.contains(v)) 
				throw new OperacionNoValida("El usuario ya tiene un vehículo con esa matrícula");
			c.getVehiculos().add(v);
			contribuyentes.actualizaContribuyente(c);
			return vehiculos.creaVehiculo(v);
		}
		return null;	
	}

	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c!=null) {
			for (Vehiculo v:c.getVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					c.getVehiculos().remove(v);
					contribuyentes.actualizaContribuyente(c);
					vehiculos.eliminaVehiculo(matricula);
					return v;
				}
			}
			throw new OperacionNoValida("El usuario no tiene un vehículo con esa matrícula");
		}
		return null;
	}

	@Override
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}	
}

