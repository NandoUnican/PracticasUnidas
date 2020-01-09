package dominio;

import java.io.Serializable;
import java.util.Date;

public class Denuncia implements Serializable{
	private long id;
	private Date fecha;
	private Double importe;
	private String causa;
	private Vehiculo vehiculoDenunciado;
	private Usuario usuario;
	
	public Denuncia(Date fecha, Double importe, String causa, Vehiculo vehiculoDenunciado, Usuario usuario) {
		this.fecha=fecha;
		this.importe=importe;
		this.causa=causa;
		this.vehiculoDenunciado=vehiculoDenunciado;
		this.usuario=usuario;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public String getCausa() {
		return causa;
	}
	
	public void setCausa(String causa) {
		this.causa=causa;
	}
	
	public Vehiculo getVehiculoDenunciado() {
		return vehiculoDenunciado;
	}

	public void setFechaEntrada(Vehiculo vehiculoDenunciado) {
		this.vehiculoDenunciado = vehiculoDenunciado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	public long getId() {
		return id;
	}
}
