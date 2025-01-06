package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Modelo de cliente")
@Entity
@Table(name = "Clientes")
public class Cliente {
	@Schema(description = "ID del Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Long id;
	
	@Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nombre;
	
	@Schema(description = "Documento del cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String documento;

	
	public List<Local> getLocales() {
		return locales;
	}

	public void setLocales(List<Local> locales) {
		this.locales = locales;
	}

	@Schema(description = "Lista de locales en los que el cliente compró")
	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Local> locales = new ArrayList<>();
	
	
	public Cliente(String nombre, String documento) {
		super();
		this.nombre = nombre;
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Cliente() {
		super();
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", documento=" + documento + "]";
	}
	
	
}
