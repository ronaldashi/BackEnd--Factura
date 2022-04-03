package com.danielpineros.apirest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielpineros.apirest.model.Cliente;
import com.danielpineros.apirest.model.Factura;
import com.danielpineros.apirest.repository.ClienteRepository;
import com.danielpineros.apirest.repository.FacturaRepository;


@Service
public class FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }


    public Optional<Factura> getFacturaById(Integer facturaId) throws Exception {
        if (!facturaRepository.existsById(facturaId)) {
            throw new Exception("Factura with id " + facturaId + " not found");
        }
        return facturaRepository.findById(facturaId);
    }


    public Factura createFactura(Integer clienteId, Factura factura) throws Exception {
        Set<Factura> facturas = new HashSet<>();
        Cliente cliente1 = new Cliente();

        Optional<Cliente> byId = clienteRepository.findById(clienteId);
        if (!byId.isPresent()) {
            throw new Exception("Cliente with id " + clienteId + " does not exist");
        }
        Cliente cliente = byId.get();

        //tie Cliente to Factura
        factura.setCliente(cliente);

        Factura factura1 = facturaRepository.save(factura);
        //tie Factura to Cliente
        facturas.add(factura1);
        cliente1.setFacturas(facturas);

        return factura1;

    }

    public Factura updateFacturaById(Integer facturaId, Factura facturaRequest) throws Exception {
        if (!facturaRepository.existsById(facturaId)) {
            throw new Exception("Factura with id " + facturaId + " not found");
        }
        Optional<Factura> factura = facturaRepository.findById(facturaId);

        if (!factura.isPresent()) {
            throw new Exception("Factura with id " + facturaId + " not found");
        }

        Factura factura1 = factura.get();
        factura1.setFecha(facturaRequest.getFecha());
        

        return facturaRepository.save(factura1);
    }

    public ResponseEntity<Object> deleteFacturaById(Integer facturaId) throws Exception {
        if (!facturaRepository.existsById(facturaId)) {
            throw new Exception("Factura with id " + facturaId + " not found");
        }

        facturaRepository.deleteById(facturaId);

        return ResponseEntity.ok().build();

    }
}
