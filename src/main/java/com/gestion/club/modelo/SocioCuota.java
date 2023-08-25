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
@Entity
@Table(name="socio_cuota")
public class SocioCuota implements Serializable {

	@EmbeddedId
	private SocioCuotaPk id;

	@Column(name = "precio")
	private float precio;

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
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonManagedReference
	@ToString.Exclude
	private Cuota cuota;

	public SocioCuota() {

	}

	public SocioCuota(SocioCuotaPk id, float precio, LocalDate fechaPago) {
		this.id = id;
		this.precio = precio;
		this.fechaPago = fechaPago;
	}

	public SocioCuotaPk crearSocioCuotaPk(long id_cuota, long id_socio){
		SocioCuotaPk socioCuotaPk = new SocioCuotaPk();
		socioCuotaPk.setIdCuota(id_cuota);
		socioCuotaPk.setIdSocio(id_socio);

		return socioCuotaPk;
	}

	public SocioCuota(SocioCuotaPk id, float precio, LocalDate fechaPago, String nombre, String apellido,
			String medioPago, Cuota cuota) {
		super();
		this.id = id;
		this.precio = precio;
		this.fechaPago = fechaPago;
		this.nombre = nombre;
		this.apellido = apellido;
		this.medioPago = medioPago;
		this.cuota = cuota;
	}

	public void setId(SocioCuotaPk id) {
		this.id = id;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public SocioCuotaPk getId() {
		return id;
	}

	public float getPrecio() {
		return precio;
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
		return "SocioCuota [id=" + id + ", precio=" + precio + ", fechaPago=" + fechaPago + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", medioPago=" + medioPago + ", cuota=" + cuota + "]";
	}



}
