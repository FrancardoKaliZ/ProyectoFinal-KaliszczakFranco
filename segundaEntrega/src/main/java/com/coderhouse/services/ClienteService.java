package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.entrarDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Local;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.LocalRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;

	@Autowired
	private LocalRepository LocalRepository;

	public List<Cliente> getAllClientes() {
		return ClienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return ClienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}

	@Transactional
	public Cliente saveCliente(Cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}

	@Transactional
	public Cliente updateCliente(Long id, Cliente ClienteDetails) {
		Cliente Cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

		Cliente.setNombre(ClienteDetails.getNombre());
		Cliente.setDocumento(ClienteDetails.getDocumento());
		return ClienteRepository.save(Cliente);
	}

	public void deleteCliente(Long id) {
		if (!ClienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		ClienteRepository.deleteById(id);

	}

	@Transactional
	public Cliente entrarClienteALocales(entrarDTO entrarDTO) {
		Cliente Cliente = ClienteRepository.findById(entrarDTO.getClienteId())
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		for (Long LocalId : entrarDTO.getLocalesIds()) {
			Local Local = LocalRepository.findById(LocalId)
					.orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));
			Cliente.getLocales().add(Local);
			Local.getClientes().add(Cliente);
			LocalRepository.save(Local);
		}
			
		return ClienteRepository.save(Cliente);
		
	}
}