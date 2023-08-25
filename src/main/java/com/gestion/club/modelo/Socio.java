package com.gestion.club.modelo;


import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@ToString
@Entity

public class Socio implements Serializable{

	@Id
	@Column(unique=true)
	private Long documento;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private LocalDate fechaNacimiento;
	@Column
	private String domicilio;
	@Column
	private Long telefono;
	@Column
	private LocalDate fechaAsociacion;

		public Long getDocumento() {
		return documento;
	}

		public String getNombre() {
		return nombre;
	}

		public String getApellido() {
		return apellido;
	}

		public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

		public String getDomicilio() {
		return domicilio;
	}

		public Long getTelefono() {
		return telefono;
	}

		public LocalDate getFechaAsociacion() {
		return fechaAsociacion;
	}

		public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		public void setApellido(String apellido) {
		this.apellido = apellido;
	}

		public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

		public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

		public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

		public void setFechaAsociacion(LocalDate fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}

}


