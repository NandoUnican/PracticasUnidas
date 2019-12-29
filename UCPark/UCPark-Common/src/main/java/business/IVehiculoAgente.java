package business;

import javax.ejb.Remote;

import dominio.Estacionamiento;

@Remote
public interface IVehiculoAgente {
	
	public Estacionamiento compruebaEstacionamiento(String matricula);
	
}
