package com.danielpineros.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.danielpineros.apirest.model.Cliente;
import com.danielpineros.apirest.repository.ClienteRepository;



@Service
public class ClienteService {

	@Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }


    public Optional<Cliente> getClienteById(Integer clienteId) throws Exception {
        if (!clienteRepository.existsById(clienteId)) {
            throw new Exception("Cliente with id " + clienteId + " not found");
        }
        return clienteRepository.findById(clienteId);
    }


    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    public Cliente updateClienteById(Integer clienteId, Cliente clienteRequest) throws Exception {
        if (!clienteRepository.existsById(clienteId)) {
            throw new Exception("Cliente with id " + clienteId + " not found");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) {
            throw new Exception("Cliente with id " + clienteId + " not found");
        }

        Cliente cliente1 = cliente.get();
        cliente1.setNombre(clienteRequest.getNombre());
        cliente1.setApellidos(clienteRequest.getApellidos());
        cliente1.setTelefono(clienteRequest.getTelefono());
        cliente1.setFecha_nacimiento(clienteRequest.getFecha_nacimiento());
        cliente1.setEmail(clienteRequest.getEmail());
        
        
        return clienteRepository.save(cliente1);

    }

    public ResponseEntity<Object> deleteClienteById(Integer clienteId) throws Exception {
        if (!clienteRepository.existsById(clienteId)) {
            throw new Exception("Cliente with id " + clienteId + " not found");
        }

        clienteRepository.deleteById(clienteId);

        return ResponseEntity.ok().build();

    }
}
