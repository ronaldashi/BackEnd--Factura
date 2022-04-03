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
import com.danielpineros.apirest.model.Productos;
import com.danielpineros.apirest.service.ProductosService;

//anotación en Spring es esencialmente una combinación de @Controller y @ResponseBody
@RestController
//Anotación que se encarga de relacionar un método con una petición http. 
@RequestMapping("/")
//El intercambio de recursos de origen cruzado (CORS) es un protocolo estándar que define la interacción entre un navegador y un servidor para manejar de forma segura las solicitudes HTTP de origen cruzado.
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosController {

	// anotaciones más habituales cuando trabajamos con Spring Framework ya que se
	// trata de la anotación que permite inyectar unas dependencias con otras dentro
	// de Spring
	@Autowired
	private ProductosService productosService;

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso Get el cual muestra todos los productos
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public List<Productos> getProducts() {
		return productosService.getProductos();
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso POST el cual crea el producto en la ruta especifica
	@RequestMapping(value = "/producto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Productos createProducto(@RequestBody Productos producto) {
		return productosService.createProducto(producto);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso GET con cual busca producto mediante su ID
	@RequestMapping(value = "/producto/{productoId}", method = RequestMethod.GET)
	public Optional<Productos> getProductoById(@PathVariable(value = "productoId") Integer productoId)
			throws Exception {
		return productosService.getProductoById(productoId);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso PUT el cual se usa para modificar mediante la recepcion de id del
	// producto
	@RequestMapping(value = "/producto", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Productos updateProducto(@PathVariable(value = "productoId") Integer productoId,
			@RequestBody Productos producto) throws Exception {
		return productosService.updateProductoById(productoId, producto);
	}

	// Anotación que se encarga de relacionar un método con una petición http en
	// este caso DELETE el cual borra el producto de la base de datos
	@RequestMapping(value = "/producto/{productoId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProductoById(@PathVariable(value = "productoId") Integer productoId)
			throws Exception {
		return productosService.deleteProductoById(productoId);
	}

}
