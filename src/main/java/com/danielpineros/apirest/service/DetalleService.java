package com.danielpineros.apirest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielpineros.apirest.model.Factura;
import com.danielpineros.apirest.model.Productos;
import com.danielpineros.apirest.model.Detalle;
import com.danielpineros.apirest.repository.FacturaRepository;
import com.danielpineros.apirest.repository.ProductosRepository;
import com.danielpineros.apirest.repository.DetalleRepository;

@Service
public class DetalleService {

	@Autowired
	DetalleRepository detalleRepository;

    @Autowired
    FacturaRepository facturaRepository;
    
    @Autowired
    ProductosRepository productosRepository;

    public List<Detalle> getAllDetalles() {
        return detalleRepository.findAll();
    }


    public Optional<Detalle> getDetalleById(Integer detalleId) throws Exception {
        if (!detalleRepository.existsById(detalleId)) {
            throw new Exception("Detalle with id " + detalleId + " not found");
        }
        return detalleRepository.findById(detalleId);
    }


    public Detalle createDetalleFac(Integer facturaId, Detalle detalle) throws Exception {
        Set<Detalle> detalles = new HashSet<>();
        Factura factura1 = new Factura();

        Optional<Factura> byId = facturaRepository.findById(facturaId);
        if (!byId.isPresent()) {
            throw new Exception("Factura with id " + facturaId + " does not exist");
        }
        Factura factura = byId.get();

        
        detalle.setFactura(factura);

        Detalle detalle1 = detalleRepository.save(detalle);
        //tie Detalle to Factura
        detalles.add(detalle1);
        factura1.setDetalles(detalles);

        return detalle1;

    }
    
    public Detalle createDetallePro(Integer productosId, Detalle detalle) throws Exception {
        Set<Detalle> detalles = new HashSet<>();
        Productos productos1 = new Productos();

        Optional<Productos> byId = productosRepository.findById(productosId);
        if (!byId.isPresent()) {
            throw new Exception("productos with id " + productosId + " does not exist");
        }
        Productos producto = byId.get();

        
        detalle.setProducto(producto);

        Detalle detalle1 = detalleRepository.save(detalle);
        //tie Detalle to Factura
        detalles.add(detalle1);
        productos1.setDetalles(detalles);

        return detalle1;

    }

    public Detalle updateDetalleById(Integer detalleId, Detalle detalleRequest) throws Exception {
        if (!detalleRepository.existsById(detalleId)) {
            throw new Exception("Detalle with id " + detalleId + " not found");
        }
        Optional<Detalle> detalle = detalleRepository.findById(detalleId);

        if (!detalle.isPresent()) {
            throw new Exception("Detalle with id " + detalleId + " not found");
        }

        Detalle detalle1 = detalle.get();
        detalle1.setCantidad(detalleRequest.getCantidad());
        detalle1.setPrecio(detalleRequest.getPrecio());        

        return detalleRepository.save(detalle1);
    }

    public ResponseEntity<Object> deleteDetalleById(Integer detalleId) throws Exception {
        if (!detalleRepository.existsById(detalleId)) {
            throw new Exception("Detalle with id " + detalleId + " not found");
        }

        detalleRepository.deleteById(detalleId);

        return ResponseEntity.ok().build();

    }
}
