package com.gestion.club.modelo;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="jugador_cuota")
public class JugadorCuota implements Serializable {

	@EmbeddedId
	private JugadorCuotaPk id;

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
	@ToString.Exclude
	private Cuota cuota;

	public JugadorCuota() {

	}

	public JugadorCuota(JugadorCuotaPk id, float precio, LocalDate fechaPago) {
		this.id = id;
		this.precio = precio;
		this.fechaPago = fechaPago;
	}

	public JugadorCuotaPk crearJugadorCuotaPk(long id_cuota, long id_jugador){
		JugadorCuotaPk jugadorCuotaPk = new JugadorCuotaPk();
		jugadorCuotaPk.setIdCuota(id_cuota);
		jugadorCuotaPk.setIdJugador(id_jugador);

		return jugadorCuotaPk;
	}

	public JugadorCuota(JugadorCuotaPk id, float precio, LocalDate fechaPago, String nombre, String apellido,
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

	public JugadorCuotaPk getId() {
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

	public void setId(JugadorCuotaPk id) {
		this.id = id;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
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
		return "JugadorCuota [id=" + id + ", precio=" + precio + ", fechaPago=" + fechaPago + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", medioPago=" + medioPago + ", cuota=" + cuota + "]";
	}


}