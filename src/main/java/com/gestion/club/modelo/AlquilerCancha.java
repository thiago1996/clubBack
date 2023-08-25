package com.gestion.club.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Entity

public class AlquilerCancha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alquiler_cancha")
	private Long id;

	@Column(nullable = false)
	float importe;

	@Column(nullable = false)
	LocalDate fecha;

	@Column(nullable = false)
	LocalTime horaInicio;

	@Column(nullable = false)
	LocalTime horaFin;

	@Column(nullable = true)
	String observaciones;

	@Column
	String medioPago;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_cancha", nullable = false)
	@ToString.Exclude
	private Cancha cancha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}



}
