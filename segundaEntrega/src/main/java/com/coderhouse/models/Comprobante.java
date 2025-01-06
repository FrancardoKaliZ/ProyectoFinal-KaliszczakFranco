package com.coderhouse.models;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Comprobante")
@Entity
@Table(name = "Comprobante")
public class Comprobante {

	@Schema(description = "ID del comprobante", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Long id;
	
	@Schema(description = "Precio total de la compra", requiredMode = Schema.RequiredMode.REQUIRED)
	private Double precioTotal;
	
	@Schema(description = "Cantidad de productos comprados", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer cantidadProductos;
	
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	@Schema(description = "Local", requiredMode = Schema.RequiredMode.REQUIRED)
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Schema(description = "Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private Cliente cliente;
	
	@Schema(description = "fecha", requiredMode = Schema.RequiredMode.REQUIRED)
	private ZonedDateTime fecha;
	
	@OneToMany(mappedBy = "comprobante")
	private List<Producto> productos = new ArrayList<>();
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Comprobante() {
		super();
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public ZonedDateTime getFecha() {
		return fecha;
	}

	public void setFecha(ZonedDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public String toString() {
		return "Comprobante [id=" + id + ", precioTotal=" + precioTotal + ", cantidadProductos=" + cantidadProductos
				+ ", local=" + local + ", cliente=" + cliente + ", productos=" + productos + "]";
	}

}
