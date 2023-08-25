package com.gestion.club.modelo;

import java.io.Serializable;

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

public class Cuota implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_cuota;
	@Column
	private int anio;
	@Column
	private int mes;
	//@Column
	//private String tipo;
	public void setId_cuota(Long id_cuota) {
		this.id_cuota = id_cuota;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Long getId_cuota() {
		return id_cuota;
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	/*
    @OneToMany(mappedBy = "cuota", cascade = CascadeType.PERSIST)
    @JsonBackReference
    @ToString.Exclude
    private List<SocioCuota> socioCuota;

    @OneToMany(mappedBy = "cuota", cascade = CascadeType.PERSIST)
    @JsonBackReference
    @ToString.Exclude
    private List<JugadorCuota> jugadorCuota;

    @OneToMany(mappedBy = "cuota", cascade = CascadeType.PERSIST)
    @JsonBackReference
    @ToString.Exclude
    private List<PagoCuotaEntrenador> pagoCuotaEntrenador;
	 */

}


