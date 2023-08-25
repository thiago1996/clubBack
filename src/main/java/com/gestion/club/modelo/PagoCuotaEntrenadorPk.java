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
public class PagoCuotaEntrenadorPk implements Serializable {

	@Column(name = "id_cuota")
	private long idCuota;
	@Column(name = "id_entrenador")
	private long idEntrenador;

	public PagoCuotaEntrenadorPk(long idCuota, long idEntrenador) {
		super();
		this.idCuota = idCuota;
		this.idEntrenador = idEntrenador;
	}

	public PagoCuotaEntrenadorPk() {
		super();
	}

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public void setIdEntrenador(long idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public long getIdEntrenador() {
		return idEntrenador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuota, idEntrenador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagoCuotaEntrenadorPk other = (PagoCuotaEntrenadorPk) obj;
		return idCuota == other.idCuota && idEntrenador == other.idEntrenador;
	}

	@Override
	public String toString() {
		return "PagoCuotaEntrenadorPk [idCuota=" + idCuota + ", idEntrenador=" + idEntrenador + "]";
	}

}