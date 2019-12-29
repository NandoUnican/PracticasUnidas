package dao;

import java.util.List;

import javax.ejb.Remote;

import dominio.Estacionamiento;

@Remote
public interface IEstacionamientosDAO {
	
	public List<Estacionamiento> estacionamientos();
	public Estacionamiento estacionamientoPorId(long id);
	public Estacionamiento creaEstacionamiento(Estacionamiento estacionamiento);
	public Estacionamiento actualizaEstacionamiento(Estacionamiento estacionamiento);
	public Estacionamiento eliminaEstacionamiento(Estacionamiento estacionamiento);
}
