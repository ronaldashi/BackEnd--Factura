package com.danielpineros.apirest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.danielpineros.apirest.model.Cliente;
import com.danielpineros.apirest.service.ClienteService;




@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
		
	
	@RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public List<Cliente> getClients() {
        return clienteService.getClientes();
    }
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }
	
	@RequestMapping(value = "/clientes/{id_cliente}", method = RequestMethod.GET)
    public Optional<Cliente> getClienteById(@PathVariable(value = "id_cliente") Integer id_cliente) throws Exception {
        return clienteService.getClienteById(id_cliente);
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente updateCliente(@PathVariable(value = "id_cliente") Integer id_cliente, @RequestBody Cliente cliente) throws Exception {
        return clienteService.updateClienteById(id_cliente, cliente);
    }

    @RequestMapping(value = "/clientes/{id_cliente}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClienteById(@PathVariable(value = "id_cliente") Integer id_cliente) throws Exception {
        return clienteService.deleteClienteById(id_cliente);
    }

}
