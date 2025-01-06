package com.coderhouse.services;

import com.coderhouse.dtos.ComprobanteCompraDTO;
import com.coderhouse.models.Comprobante;
import com.coderhouse.models.Local;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ComprobanteRepository;
import com.coderhouse.repositories.LocalRepository;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.time.ZonedDateTime;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired LocalRepository localRepository;
    
    @Autowired
    private WorldClockService worldClockService; 

    @Transactional
    public String comprar(ComprobanteCompraDTO request) {
   
        Optional<Cliente> clienteOpt = clienteRepository.findById(request.getCliente().getClienteid());
        if (!clienteOpt.isPresent()) {
            return "Cliente no encontrado";
        }
        Cliente cliente = clienteOpt.get();
        

        
        double totalAPagar = 0;
        int cantidadProductos = 0;

        for (ComprobanteCompraDTO.LineaDTO linea : request.getLineas()) {
            Long productoId = linea.getProducto().getProductoid();
            Optional<Producto> productoOpt = productoRepository.findById(productoId);
            if (!productoOpt.isPresent()) {
                return "Producto con ID " + productoId + " no encontrado";
            }
            Producto producto = productoOpt.get();

            if (producto.getStock() < linea.getCantidad()) {
                return "No hay suficiente stock para el producto " + producto.getNombre();
            }
            totalAPagar += producto.getValor() * linea.getCantidad();
            cantidadProductos += linea.getCantidad();
            producto.setStock(producto.getStock() - linea.getCantidad());
            productoRepository.save(producto);
        }


        ZonedDateTime fechaActual = worldClockService.obtenerFechaActual();

        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setPrecioTotal(totalAPagar);
        comprobante.setCantidadProductos(cantidadProductos);
        comprobante.setFecha(fechaActual);
        comprobanteRepository.save(comprobante);

        return "Compra realizada con éxito. Total a pagar: " + totalAPagar + ". Fecha de compra: " + fechaActual;
    }

    public Comprobante getComprobante(Long id) {
        return comprobanteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Comprobante no encontrado"));
    }

    public List<Comprobante> getAllComprobantes() {
        return comprobanteRepository.findAll();
    }
    
    public void deleteComprobante(Long id) {
        if (comprobanteRepository.existsById(id)) {
            comprobanteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Comprobante no encontrado");
        }
    }
}
