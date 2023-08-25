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

public class Cancha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cancha")
	private Long id;

	@Column(unique = true, nullable = false)
	private int numero;
	@Column(nullable = false)
	private String descripcion;

	public Cancha() {

	}

	public Cancha(int numero, String descripcion) {

		this.numero = numero;
		this.descripcion = descripcion;
	}

	public Cancha(Long id, int numero, String descripcion) {

		this.id = id;
		this.numero = numero;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_cancha) {
		this.id = id_cancha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
