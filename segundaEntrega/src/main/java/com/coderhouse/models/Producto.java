package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Productos")
public class Producto {
	@Schema(description = "ID del producto", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Long id;
	
	@Schema(description = "Nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nombre;
	
	@Schema(description = "Valor del producto", requiredMode = Schema.RequiredMode.REQUIRED)
	private Double valor;
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Schema(description = "Stock del producto", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer stock;
	
	
	@ManyToOne
    @JoinColumn(name = "comprobante_id")
	private Comprobante comprobante;  
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "LocalXproductos",
			joinColumns = @JoinColumn(name = "local_id"),
			inverseJoinColumns = @JoinColumn(name = "producto_id")
			)
	@JsonIgnore
	private List<Local> locales = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "comprobante_id")
	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Producto() {
		super();
	}

	public Producto(String nombre, double valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Local> getLocales() {
		return locales;
	}

	public void setLocales(List<Local> locales) {
		this.locales = locales;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", valor=" + valor + ", locales=" + locales + "]";
	}
	
}
