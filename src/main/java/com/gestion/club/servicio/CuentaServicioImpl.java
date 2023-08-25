package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Cuenta;
import com.gestion.club.repositorio.CuentaRepositorio;

@Service
public class CuentaServicioImpl implements CuentaServicio {

	@Autowired
	CuentaRepositorio cuentaRepositorio;

	@Override
	public List<Cuenta> mostrarCuentas() {
		return cuentaRepositorio.findAll();
	}

	@Override
	public void ingresoEfectivo(float importe) {

		Cuenta cuenta = new Cuenta();

		Optional<Cuenta> cuentaEncontrada = this.cuentaRepositorio.findById(1L);
		if (cuentaEncontrada.get() != null) {

			cuenta.setId_cuenta(cuentaEncontrada.get().getId_cuenta());
			cuenta.setSaldoDebito(cuentaEncontrada.get().getSaldoDebito());
			cuenta.setSaldoEfectivo(cuentaEncontrada.get().getSaldoEfectivo() + importe);

			cuentaRepositorio.save(cuenta);
		}
	}

	@Override
	public void ingresoDebito(float importe) {

		Cuenta cuenta = new Cuenta();

		Optional<Cuenta> cuentaEncontrada = this.cuentaRepositorio.findById(1L);
		if (cuentaEncontrada.get() != null) {

			cuenta.setId_cuenta(cuentaEncontrada.get().getId_cuenta());
			cuenta.setSaldoEfectivo(cuentaEncontrada.get().getSaldoEfectivo());
			cuenta.setSaldoDebito(cuentaEncontrada.get().getSaldoDebito() + importe);

			cuentaRepositorio.save(cuenta);
		}

	}

	@Override
	public Boolean egresoEfectivo(float importe) {

		Cuenta cuenta = new Cuenta();
		Boolean control = false;

		Optional<Cuenta> cuentaEncontrada = this.cuentaRepositorio.findById(1L);
		if (cuentaEncontrada.get() != null) {

			if (cuentaEncontrada.get().getSaldoEfectivo() - importe >= 0) {

				cuenta.setId_cuenta(cuentaEncontrada.get().getId_cuenta());
				cuenta.setSaldoDebito(cuentaEncontrada.get().getSaldoDebito());
				cuenta.setSaldoEfectivo(cuentaEncontrada.get().getSaldoEfectivo() - importe);

				cuentaRepositorio.save(cuenta);
				control = true;
			}

		}
		return control;
	}

	@Override
	public Boolean egresoDebito(float importe) {

		Cuenta cuenta = new Cuenta();
		Boolean control = false;

		Optional<Cuenta> cuentaEncontrada = this.cuentaRepositorio.findById(1L);
		if (cuentaEncontrada.get() != null) {

			if (cuentaEncontrada.get().getSaldoDebito() - importe >= 0) {
				cuenta.setId_cuenta(cuentaEncontrada.get().getId_cuenta());
				cuenta.setSaldoEfectivo(cuentaEncontrada.get().getSaldoEfectivo());
				cuenta.setSaldoDebito(cuentaEncontrada.get().getSaldoDebito() - importe);

				cuentaRepositorio.save(cuenta);
				control = true;

			}

		}

		return control;

	}

}
