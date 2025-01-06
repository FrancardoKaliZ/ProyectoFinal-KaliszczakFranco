package com.coderhouse.controllers;

import com.coderhouse.models.Comprobante;
import com.coderhouse.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coderhouse.dtos.ComprobanteCompraDTO;

import java.util.List;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<String> crearComprobante(@RequestBody ComprobanteCompraDTO request) {
        String response = comprobanteService.comprar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Comprobante getComprobante(@PathVariable Long id) {
        return comprobanteService.getComprobante(id);
    }

    @GetMapping
    public List<Comprobante> getAllComprobantes() {
        return comprobanteService.getAllComprobantes();
    }

    @DeleteMapping("/{id}")
    public void deleteComprobante(@PathVariable Long id) {
        comprobanteService.deleteComprobante(id);
    }
}
