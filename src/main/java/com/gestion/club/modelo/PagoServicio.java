package com.gestion.club.modelo;

import java.time.LocalDate;

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

public class PagoServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String descripcion;
	@Column
	private float importe;
	@Column
	private String medioPago;
	@Column
	private LocalDate fecha;

	public PagoServicio(Long id, String descripcion, float importe, String medioPago, LocalDate fecha) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.importe = importe;
		this.medioPago = medioPago;
		this.fecha = fecha;
	}

	public PagoServicio() {
		super();
	}

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

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "PagoServicio [id=" + id + ", descripcion=" + descripcion + ", importe=" + importe + ", medioPago="
				+ medioPago + ", fecha=" + fecha + "]";
	}


}
