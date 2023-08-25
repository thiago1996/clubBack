package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Cuenta;

public interface CuentaServicio {

	List<Cuenta> mostrarCuentas();

	void ingresoEfectivo(float importe);

	void ingresoDebito(float importe);

	Boolean egresoEfectivo(float importe);

	Boolean egresoDebito(float importe);
}
