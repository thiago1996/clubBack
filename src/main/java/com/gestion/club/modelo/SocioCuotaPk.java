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
public class SocioCuotaPk implements Serializable {

	@Column(name = "id_cuota")
	private long idCuota;
	@Column(name = "id_socio")
	private long idSocio;

	public SocioCuotaPk() {
		super();
	}

	public SocioCuotaPk(long idCuota, long idSocio) {
		super();
		this.idCuota = idCuota;
		this.idSocio = idSocio;
	}

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public void setIdSocio(long idSocio) {
		this.idSocio = idSocio;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public long getIdSocio() {
		return idSocio;
	}

	@Override
	public String toString() {
		return "SocioCuotaPk [idCuota=" + idCuota + ", idSocio=" + idSocio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuota, idSocio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocioCuotaPk other = (SocioCuotaPk) obj;
		return idCuota == other.idCuota && idSocio == other.idSocio;
	}

}
