package hibernate.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competidor")
public class Competidor {
	@Id
	private Long id;
	private Integer numero;
	private String nombre;
	
	public Competidor() {
		super();
	}
	
	public Competidor(Long id, Integer numero, String nombre) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "numero: "+numero+
				", Nombre: "+nombre;
	}
	
	
	
	

}
