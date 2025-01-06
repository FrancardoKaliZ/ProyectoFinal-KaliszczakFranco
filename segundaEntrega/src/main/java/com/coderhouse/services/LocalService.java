package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Producto;
import com.coderhouse.dtos.asignarProductosDTO;
import com.coderhouse.models.Local;
import com.coderhouse.repositories.ProductoRepository;
import com.coderhouse.repositories.LocalRepository;

import jakarta.transaction.Transactional;

@Service
public class LocalService {

	@Autowired
	private LocalRepository LocalRepository;

	@Autowired
	private ProductoRepository ProductoRepository;

	public List<Local> getAllLocales() {
		return LocalRepository.findAll();
	}

	public Local getLocalById(Long id) {
		return LocalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));

	}

	@Transactional
	public Local createLocal(Local Local) {
		return LocalRepository.save(Local);
	}

	@Transactional
	public Local updateLocal(Long id, Local LocalDetails) {
		Local Local = LocalRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));
		Local.setNombre(LocalDetails.getNombre());
		return LocalRepository.save(Local);

	}

	public void deleteLocal(Long id) {
		if (LocalRepository.existsById(id)) {
			LocalRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Local no encontrado");
		}
	}

	@Transactional
	public Local asignarProductosALocal(asignarProductosDTO asignarProductosDTO) {
		Local local = LocalRepository.findById(asignarProductosDTO.getLocalId())
				.orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));
		for (Long ProductoId : asignarProductosDTO.getProductosIds()) {
			Producto producto = ProductoRepository.findById(ProductoId)
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
			local.getProductos().add(producto);
			producto.getLocales().add(local);
			ProductoRepository.save(producto);
		}

		return LocalRepository.save(local);

	}

}