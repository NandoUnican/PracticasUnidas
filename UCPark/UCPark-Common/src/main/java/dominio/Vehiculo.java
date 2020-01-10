package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vehiculos")
public class Vehiculo implements Serializable {
	@Id
	private long id;
	private String matricula;
	private String marca;
	private String modelo;
	@ManyToOne
	@JoinColumn(name="usuario_fk")
	private Usuario propietario;
	@OneToOne
	@JoinColumn(name="estacionamientoEnVigor_fk")
	private Estacionamiento estacionamientoEnVigor;
	@OneToMany(mappedBy="vehiculoDenunciado", fetch=FetchType.EAGER)
	private List<Denuncia> denuncias;
	
	public Vehiculo (String matricula, String marca, String modelo) {
		// id se carga automáticamente
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
		this.estacionamientoEnVigor=null;
		this.denuncias=new ArrayList<Denuncia>();
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Usuario propietario) {
		this.propietario=propietario;
	}
	
	public Estacionamiento getEstacionamientoEnVigor() {
		return estacionamientoEnVigor;
	}
	
	public void setEstacionamientoEnVigor(Estacionamiento estacionamientoEnVigor) {
		this.estacionamientoEnVigor=estacionamientoEnVigor;
	}
	
	public List<Denuncia> getDenuncias() {
		return denuncias;
	}
	
	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias=denuncias;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	//Constructor vacio
	public Vehiculo() {}
}
