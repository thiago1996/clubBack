package com.gestion.club.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class JugadorCuotaPk implements Serializable {

	@Column(name = "id_cuota")
	private long idCuota;
	@Column(name = "id_jugador")
	private long idJugador;

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public void setIdJugador(long idJugador) {
		this.idJugador = idJugador;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public long getIdJugador() {
		return idJugador;
	}

	public JugadorCuotaPk(long idCuota, long idJugador) {
		super();
		this.idCuota = idCuota;
		this.idJugador = idJugador;
	}

	public JugadorCuotaPk() {
		super();

	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuota, idJugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JugadorCuotaPk other = (JugadorCuotaPk) obj;
		return idCuota == other.idCuota && idJugador == other.idJugador;
	}

	@Override
	public String toString() {
		return "JugadorCuotaPk [idCuota=" + idCuota + ", idJugador=" + idJugador + "]";
	}


}