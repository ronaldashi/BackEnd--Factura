//paquete en el cual se guarda todos los controles de cada clase 
package com.danielpineros.apirest.repository;

//liberias importadas para la cardinalidad entre tablas
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielpineros.apirest.model.Detalle;

//La anotación @Repository es una especialización de la anotación @Component que se utiliza para indicar que la clase proporciona el mecanismo para la operación de almacenamiento, recuperación, actualización, eliminación y búsqueda en objetos.
@Repository
//interface detalle mediante la clave integer de detalle
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
	
	

}
