package com.gestion.club.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Cuenta;
import com.gestion.club.servicio.CuentaServicio;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class CuentaControlador {

	@Autowired
	private CuentaServicio cuentaServicio;

	@GetMapping("/mostrar")
	public Iterable<Cuenta> mostrarCuentas() {
		return cuentaServicio.mostrarCuentas();
	}

	@PostMapping("/ingresoEfectivo/{importe}")
	public void ingresoEfectivo(@PathVariable(value = "importe") float importe) {
		this.cuentaServicio.ingresoEfectivo(importe);
	}

	@PostMapping("/ingresoDebito/{importe}")
	public void ingresoDebito(@PathVariable(value = "importe") float importe) {
		this.cuentaServicio.ingresoDebito(importe);
	}

	@PostMapping("/egresoEfectivo/{importe}")
	public Boolean egresoEfectivo(@PathVariable(value = "importe") float importe) {
		return this.cuentaServicio.egresoEfectivo(importe);
	}

	@PostMapping("/egresoDebito/{importe}")
	public Boolean egresoDebito(@PathVariable(value = "importe") float importe) {
		return this.cuentaServicio.egresoDebito(importe);
	}
}
