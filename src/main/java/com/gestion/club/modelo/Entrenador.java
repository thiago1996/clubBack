package com.gestion.club.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Entrenador {

	@Id
	@Column(name = "documento_entrenador", unique = true)
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
	private LocalDate fechaAlta;

	@ManyToMany(cascade = { CascadeType.PERSIST})
	@JoinTable(name = "entrenador_categoria",
	joinColumns = @JoinColumn(name = "entrenador_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
		System.out.println(categoria);
		System.out.println(categorias);
		// categoria.getEntrenadores().add(this);
	}
	public void eliminarCategoria(Categoria categoria) {
		categorias.remove(categoria);
		// categoria.getEntrenadores().remove(this);
	}

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

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
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

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}

