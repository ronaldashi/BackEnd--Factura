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
import com.danielpineros.apirest.model.Detalle;
import com.danielpineros.apirest.service.DetalleService;

//anotación en Spring es esencialmente una combinación de @Controller y @ResponseBody
@RestController
//Anotación que se encarga de relacionar un método con una petición http. 
@RequestMapping("/")
//El intercambio de recursos de origen cruzado (CORS) es un protocolo estándar que define la interacción entre un navegador y un servidor para manejar de forma segura las solicitudes HTTP de origen cruzado.
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleController {

	// anotaciones más habituales cuando trabajamos con Spring Framework ya que se
	// trata de la anotación que permite inyectar unas dependencias con otras dentro
	// de Spring
	@Autowired
	private DetalleService detalleService;

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso Get el cual muestra todos los detalles
	@RequestMapping(value = "/getAllDetalles", method = RequestMethod.GET)
	public List<Detalle> getDetalles() {
		return detalleService.getAllDetalles();
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso POST el cual crea el cliente en la ruta especifica tomando como
	// objeto detalle tomando como referencia el id de la factura
	@RequestMapping(value = "/{facturaId}/detalle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Detalle createDetalleFac(@PathVariable(value = "facturaId") Integer facturaId, @RequestBody Detalle detalle)
			throws Exception {
		return detalleService.createDetalleFac(facturaId, detalle);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso POST el cual crea el cliente en la ruta especifica tomando como
	// objeto cliente tomando como referencia el id del producto
	@RequestMapping(value = "/{productoId}/detalles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Detalle createDetallePro(@PathVariable(value = "productoId") Integer productoId,
			@RequestBody Detalle detalle) throws Exception {
		return detalleService.createDetallePro(productoId, detalle);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso GET con cual busca detalle mediante su ID
	@RequestMapping(value = "/detalle/{detalleId}", method = RequestMethod.GET)
	public Optional<Detalle> getDetalleById(@PathVariable(value = "detalleId") Integer detalleId) throws Exception {
		return detalleService.getDetalleById(detalleId);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso PUT el cual se usa para modificar mediante la recepcion de id del
	// detalle
	@RequestMapping(value = "/detalle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Detalle updateDetalle(@PathVariable(value = "detalleId") Integer detalleId, @RequestBody Detalle detalle)
			throws Exception {
		return detalleService.updateDetalleById(detalleId, detalle);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso DELETE el cual borra el detalle de la base de datos
	@RequestMapping(value = "/detalle/{detalleId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDetalleById(@PathVariable(value = "detalleId") Integer detalleId)
			throws Exception {
		return detalleService.deleteDetalleById(detalleId);
	}
}
