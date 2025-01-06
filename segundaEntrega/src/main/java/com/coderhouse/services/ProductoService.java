package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository ProductoRepository;

	public List<Producto> findAll() {
		return ProductoRepository.findAll();
	}

	public Producto getProductoById(Long id) {
		return ProductoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

	}

	public boolean existsById(Long id) {
        return ProductoRepository.existsById(id);
    }
	
	@Transactional
	public Producto createProducto(Producto Producto) {
		return ProductoRepository.save(Producto);
	}

	@Transactional
	public Producto updateProducto(Long id, Producto categoraDetails) {
		Producto Producto = ProductoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		Producto.setNombre(categoraDetails.getNombre());
		return ProductoRepository.save(Producto);

	}

	public void deleteById(Long id) {
		ProductoRepository.deleteById(id);
	}

}