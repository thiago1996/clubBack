package com.gestion.club.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name="pago_cuota_entrenador")
public class PagoCuotaEntrenador implements Serializable {

	@EmbeddedId
	private PagoCuotaEntrenadorPk id;

	@Column(name = "importe")
	private float importe;

	@Column(name = "fecha_pago")
	private LocalDate fechaPago;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "medio_pago")
	private String medioPago;

	@ManyToOne
	@JoinColumn(name="id_cuota", insertable = false, updatable = false)
	@ToString.Exclude
	@JsonManagedReference
	private Cuota cuota;

	public PagoCuotaEntrenadorPk crearPagoCuotaEntrenadorPk(long id_cuota, long id_entrenador){
		PagoCuotaEntrenadorPk pagoCuotaEntrenadorPk = new PagoCuotaEntrenadorPk();
		pagoCuotaEntrenadorPk.setIdCuota(id_cuota);
		pagoCuotaEntrenadorPk.setIdEntrenador(id_entrenador);

		return pagoCuotaEntrenadorPk;
	}

	public PagoCuotaEntrenador() {
		super();

	}

	public PagoCuotaEntrenador(PagoCuotaEntrenadorPk id, float importe, LocalDate fechaPago, String nombre,
			String apellido, String medioPago, Cuota cuota) {
		super();
		this.id = id;
		this.importe = importe;
		this.fechaPago = fechaPago;
		this.nombre = nombre;
		this.apellido = apellido;
		this.medioPago = medioPago;
		this.cuota = cuota;
	}

	public void setId(PagoCuotaEntrenadorPk id) {
		this.id = id;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public PagoCuotaEntrenadorPk getId() {
		return id;
	}

	public float getImporte() {
		return importe;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	@Override
	public String toString() {
		return "PagoCuotaEntrenador [id=" + id + ", importe=" + importe + ", fechaPago=" + fechaPago + ", nombre="
				+ nombre + ", apellido=" + apellido + ", medioPago=" + medioPago + ", cuota=" + cuota + "]";
	}



}
