package hibernate.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera {
	@Id
	private Long id;
	private Date fecha;
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Competidor> competidores;
	
	public Carrera() {
		super();
	}
	
	public Carrera(Long id, Date fecha, String nombre, List<Competidor> competidores) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nombre = nombre;
		this.competidores = competidores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Competidor> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(List<Competidor> competidores) {
		this.competidores = competidores;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", competidores=" + competidores + "]";
	}
	
	
	
	

}
