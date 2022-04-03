package com.danielpineros.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielpineros.apirest.model.Productos;
import com.danielpineros.apirest.repository.ProductosRepository;

@Service
public class ProductosService {

	@Autowired
    ProductosRepository productoRepository;

    public List<Productos> getProductos() {
        return productoRepository.findAll();
    }


    public Optional<Productos> getProductoById(Integer productoId) throws Exception {
        if (!productoRepository.existsById(productoId)) {
            throw new Exception("Producto with id " + productoId + " not found");
        }
        return productoRepository.findById(productoId);
    }


    public Productos createProducto(Productos producto) {
        return productoRepository.save(producto);

    }

    public Productos updateProductoById(Integer productoId, Productos productoRequest) throws Exception {
        if (!productoRepository.existsById(productoId)) {
            throw new Exception("Producto with id " + productoId + " not found");
        }
        Optional<Productos> producto = productoRepository.findById(productoId);

        if (!producto.isPresent()) {
            throw new Exception("Producto with id " + productoId + " not found");
        }

        Productos producto1 = producto.get();
        producto1.setNombre(productoRequest.getNombre());
        producto1.setPrecio(productoRequest.getPrecio());
        producto1.setStock(productoRequest.getStock());
        
        return productoRepository.save(producto1);

    }

    public ResponseEntity<Object> deleteProductoById(Integer productoId) throws Exception {
        if (!productoRepository.existsById(productoId)) {
            throw new Exception("Producto with id " + productoId + " not found");
        }

        productoRepository.deleteById(productoId);

        return ResponseEntity.ok().build();

    }
}