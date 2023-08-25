package com.gestion.club.modelo;

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

public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cuenta;

	@Column
	private float saldoEfectivo;
	@Column
	private float saldoDebito;

	public Cuenta(Long id_cuenta, float saldoEfectivo, float saldoDebito) {
		super();
		this.id_cuenta = id_cuenta;
		this.saldoEfectivo = saldoEfectivo;
		this.saldoDebito = saldoDebito;
	}

	public Cuenta() {
		super();
	}

	public Long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public float getSaldoEfectivo() {
		return saldoEfectivo;
	}

	public void setSaldoEfectivo(float saldoEfectivo) {
		this.saldoEfectivo = saldoEfectivo;
	}

	public float getSaldoDebito() {
		return saldoDebito;
	}

	public void setSaldoDebito(float saldoDebito) {
		this.saldoDebito = saldoDebito;
	}

	@Override
	public String toString() {
		return "Cuenta [id_cuenta=" + id_cuenta + ", saldoEfectivo=" + saldoEfectivo + ", saldoDebito=" + saldoDebito
				+ "]";
	}


}
