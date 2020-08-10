package hibernate.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.result.NoMoreReturnsException;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	private Long id;
	private String nombre;
	private String descripcion;
	private Double precio;
	
	public Menu() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		String mensaje = "\t-nombre: " + nombre + "\n";
		mensaje += "\t-descripcion: " + descripcion + "\n";
		mensaje += "\t-precio: " + precio;
		return mensaje;
	}
	
	
}
