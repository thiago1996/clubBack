package com.gestion.club.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@Column(unique=true)
	private String nombre;

	private String tipo;

	private String deporte;

	// @ManyToMany(mappedBy = "categorias")
	// public List<Entrenador> entrenadores = new ArrayList<>();


	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria",cascade = CascadeType.ALL)
	//@LazyCollection(LazyCollectionOption.FALSE)
	// private List<Jugador> jugadores;

	public Categoria(){

	}

	public Categoria(String nombre, String tipo, String deporte) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.deporte= deporte;
	}

	public Categoria(Long id_categoria, String nombre, String tipo, String deporte) {
		this.id = id_categoria;
		this.nombre = nombre;
		this.tipo = tipo;
		this.deporte = deporte;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	/*
    @JsonManagedReference
    public List<Jugador> getJugadores(){
        return jugadores;

    }
	 */
}



