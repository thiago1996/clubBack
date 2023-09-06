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

public class Bufe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bufe")
	private Long id;

	@Column(unique = true, nullable = false)
	private int numeroBufe;

	public Bufe(Long id, int numero_bufe) {
		super();
		this.id = id;
		this.numeroBufe = numero_bufe;
	}

	public Bufe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroBufe() {
		return numeroBufe;
	}

	public void setNumeroBufe(int numero_bufe) {
		this.numeroBufe = numero_bufe;
	}

	@Override
	public String toString() {
		return "Bufe [id=" + id + ", numeroBufe=" + numeroBufe + "]";
	}


}
