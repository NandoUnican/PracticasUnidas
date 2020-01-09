package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Estacionamientos")
public class Estacionamiento implements Serializable{
	@Id
	private long id;
	private Double importe;
	private int minutos;
	private Date horaInicio;
	private boolean finalizado;
	@OneToOne
	@JoinColumn(name="vehiculo_fk")
	private Vehiculo vehiculo;
	
	public Estacionamiento(Double importe, int minutos, Date horaInicio, Vehiculo vehiculo) {
		this.importe=importe;
		this.minutos=minutos;
		this.horaInicio=horaInicio;
		this.finalizado=false;
		this.vehiculo=vehiculo;
	}
	
	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setFechaEntrada(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public long getId() {
		return id;
	}
	
	//Constructor vacio
	public Estacionamiento() {}
}
