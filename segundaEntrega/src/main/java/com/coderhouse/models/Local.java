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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Locales")
public class Local {
	@Schema(description = "ID del local", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Long id;
	
	@Schema(description = "Nombre del local", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nombre;
	
	@Schema(description = "Calle del local", requiredMode = Schema.RequiredMode.REQUIRED)
	private String calle;
	
	@Schema(description = "Numero de la calle del local", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numero;
	
	@Schema(description = "Productos del local", requiredMode = Schema.RequiredMode.REQUIRED)
	@ManyToMany(mappedBy = "locales", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "local_cliente",
			joinColumns = @JoinColumn(name = "local_id"),
			inverseJoinColumns = @JoinColumn(name = "cliente_id")
			)
	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<>();
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Local() {
		super();
	}

	public Local(String nombre, String calle, Integer numero) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;

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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nombre=" + nombre + ", calle=" + calle + ", numero=" + numero + ", productos="
				+ productos + "]";
	}
	
	
	
}
