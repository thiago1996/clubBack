package com.gestion.club.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
@ToString

public class Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaccion")
	private Long id;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	LocalDate fecha;

	@Column(nullable = false)
	String tipo;

	@Column(nullable = false)
	float importe;

	@Column(nullable = false)
	String medioPago;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_alquiler_bufe")
	@ToString.Exclude
	private AlquilerBufe alquilerBufe;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_alquiler_cancha")
	@ToString.Exclude
	private AlquilerCancha alquilerCancha;
	// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "documento_jugador")
	@ToString.Exclude
	private Jugador jugador;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "documento_socio")
	@ToString.Exclude
	private Socio socio;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "documento_entrenador")
	@ToString.Exclude
	private Entrenador entrenador;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_cuota")
	@ToString.Exclude
	private Cuota cuota;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_pago_servicio")
	@ToString.Exclude
	private PagoServicio pagoServicio;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_partido")
	@ToString.Exclude
	private Partido partido;

	public Transaccion() {
		super();
	}

	public Transaccion(Long id, String descripcion, LocalDate fecha, String tipo, float importe, String medioPago,
			AlquilerBufe alquilerBufe, AlquilerCancha alquilerCancha, Jugador jugador, Socio socio,
			Entrenador entrenador, Cuota cuota, PagoServicio pagoServicio, Partido partido) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.medioPago = medioPago;
		this.alquilerBufe = alquilerBufe;
		this.alquilerCancha = alquilerCancha;
		this.jugador = jugador;
		this.socio = socio;
		this.entrenador = entrenador;
		this.cuota = cuota;
		this.pagoServicio = pagoServicio;
		this.partido = partido;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public AlquilerBufe getAlquilerBufe() {
		return alquilerBufe;
	}

	public void setAlquilerBufe(AlquilerBufe alquilerBufe) {
		this.alquilerBufe = alquilerBufe;
	}

	public AlquilerCancha getAlquilerCancha() {
		return alquilerCancha;
	}

	public void setAlquilerCancha(AlquilerCancha alquilerCancha) {
		this.alquilerCancha = alquilerCancha;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public PagoServicio getPagoServicio() {
		return pagoServicio;
	}

	public void setPagoServicio(PagoServicio pagoServicio) {
		this.pagoServicio = pagoServicio;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", tipo=" + tipo
				+ ", importe=" + importe + ", medioPago=" + medioPago + ", alquilerBufe=" + alquilerBufe
				+ ", alquilerCancha=" + alquilerCancha + ", jugador=" + jugador + ", socio=" + socio + ", entrenador="
				+ entrenador + ", cuota=" + cuota + ", pagoServicio=" + pagoServicio + ", partido=" + partido + "]";
	}

}
