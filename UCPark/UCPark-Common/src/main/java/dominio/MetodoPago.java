package dominio;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MetodosPago")
public class MetodoPago implements Serializable{
	@Id
	private int id;
	// Constructor vacio
	public MetodoPago() {}
}
