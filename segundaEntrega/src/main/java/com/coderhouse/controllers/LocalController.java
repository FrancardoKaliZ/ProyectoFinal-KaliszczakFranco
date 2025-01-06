package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.asignarProductosDTO;
import com.coderhouse.models.Local;
import com.coderhouse.services.LocalService;

@RestController
@RequestMapping("/api/Locales")
public class LocalController {

	@Autowired
	private LocalService LocalService;

	@GetMapping
	public ResponseEntity<List<Local>> getAllLocals() {
		try {
			List<Local> Locals = LocalService.getAllLocales();
			return ResponseEntity.ok(Locals);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Local> getLocalById(@PathVariable Long id) {
		try {
			Local Local = LocalService.getLocalById(id);
			return ResponseEntity.ok(Local);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Local> createLocal(@RequestBody Local Local) {
		try {
			Local createdLocal = LocalService.createLocal(Local);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdLocal);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Local> updateLocal(@PathVariable Long id, @RequestBody Local LocalDetails) {
		try {
			Local updatedLocal = LocalService.updateLocal(id, LocalDetails);
			return ResponseEntity.ok(updatedLocal);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
		try {
			LocalService.deleteLocal(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/asignar")
	public ResponseEntity<Local> asignarProductos(@RequestBody asignarProductosDTO asignarProductosDTO){
		try {
			
			Local LocalActualizado = LocalService.asignarProductosALocal(asignarProductosDTO);
			return ResponseEntity.ok(LocalActualizado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}