package com.gestion.club.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partido")
	private Long id;
	@Column
	private String descripcion;
	@Column
	private String cancha;

	@Column
	private LocalDate fecha;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_categoria")
	@ToString.Exclude
	private Categoria categoria;

	@Column(nullable = true)
	private float ingresoEntradas;

	@Column(nullable = true)
	private float gastoArbitros;

	@Column(nullable = true)
	private float gastoSeguridad;

	@Column(nullable = true)
	private float gastoMedicos;

	@Column(nullable = true)
	private float gastoExtra;

	@Column(nullable = true)
	private String observaciones;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCancha() {
		return cancha;
	}

	public void setCancha(String cancha) {
		this.cancha = cancha;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public float getIngresoEntradas() {
		return ingresoEntradas;
	}

	public void setIngresoEntradas(float ingresoEntradas) {
		this.ingresoEntradas = ingresoEntradas;
	}

	public float getGastoArbitros() {
		return gastoArbitros;
	}

	public void setGastoArbitros(float gastoArbitros) {
		this.gastoArbitros = gastoArbitros;
	}

	public float getGastoSeguridad() {
		return gastoSeguridad;
	}

	public void setGastoSeguridad(float gastoSeguridad) {
		this.gastoSeguridad = gastoSeguridad;
	}

	public float getGastoMedicos() {
		return gastoMedicos;
	}

	public void setGastoMedicos(float gastoMedicos) {
		this.gastoMedicos = gastoMedicos;
	}

	public float getGastoExtra() {
		return gastoExtra;
	}

	public void setGastoExtra(float gastoExtra) {
		this.gastoExtra = gastoExtra;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


}
