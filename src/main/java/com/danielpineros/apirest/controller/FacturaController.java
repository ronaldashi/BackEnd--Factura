//paquete en el cual se guarda todos los controles de cada clase 
package com.danielpineros.apirest.controller;

//liberias importadas para la cardinalidad entre tablas
import java.util.List;
import java.util.Optional;

//librerias para los apuntadores de cada metodo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//clases importadas mediante las cuales se usaron por la relacion entre estas
import com.danielpineros.apirest.model.Factura;
import com.danielpineros.apirest.service.FacturaService;

//anotación en Spring es esencialmente una combinación de @Controller y @ResponseBody
@RestController
//Anotación que se encarga de relacionar un método con una petición http. 
@RequestMapping("/")
//El intercambio de recursos de origen cruzado (CORS) es un protocolo estándar que define la interacción entre un navegador y un servidor para manejar de forma segura las solicitudes HTTP de origen cruzado.
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {

	// anotaciones más habituales cuando trabajamos con Spring Framework ya que se
	// trata de la anotación que permite inyectar unas dependencias con otras dentro
	// de Spring
	@Autowired
	private FacturaService facturaService;

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso Get el cual muestra todos las facturas
	@RequestMapping(value = "/getAllFacturas", method = RequestMethod.GET)
	public List<Factura> getFacturas() {
		return facturaService.getAllFacturas();
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso POST el cual crea la factura en la ruta especifica tomando como
	// objeto detalle tomando como referencia el id del cliente

	@RequestMapping(value = "/{clienteId}/factura", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Factura createFactura(@PathVariable(value = "clienteId") Integer clienteId, @RequestBody Factura factura)
			throws Exception {
		return facturaService.createFactura(clienteId, factura);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso GET con cual busca la factura mediante su ID
	@RequestMapping(value = "/factura/{facturaId}", method = RequestMethod.GET)
	public Optional<Factura> getFacturaById(@PathVariable(value = "facturaId") Integer facturaId) throws Exception {
		return facturaService.getFacturaById(facturaId);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
		// este caso PUT el cual se usa para modificar mediante la recepcion de id del
		// la factura
	@RequestMapping(value = "/factura", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Factura updateFactura(@PathVariable(value = "facturaId") Integer facturaId, @RequestBody Factura factura)
			throws Exception {
		return facturaService.updateFacturaById(facturaId, factura);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
		// este caso DELETE el cual borra la factura de la base de datos
		
	@RequestMapping(value = "/factura/{facturaId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFacturaById(@PathVariable(value = "facturaId") Integer facturaId)
			throws Exception {
		return facturaService.deleteFacturaById(facturaId);
	}
}
