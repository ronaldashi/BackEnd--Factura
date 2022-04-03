//paquete en el cual se guarda todos los controles de cada clase 
package com.danielpineros.apirest.model;

//liberias importadas para la cardinalidad entre tablas
import java.util.Date;
import javax.persistence.*;

//librerias para los apuntadores de cada metodo
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//es una clase de Java ligera, cuyo estado es persistido de manera asociada a una tabla en una base de datos relacional
@Entity
//@Table se usará para nombrar la tabla en la base de datos
@Table(name = "Factura")
//Java facilita el almacenamiento y transmisión del estado de un objeto mediante un mecanismo conocido con el nombre de serialización
public class Factura implements Serializable {

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "num_factura", nullable = false, length = 10)
	// Para determinar el ID de una entidad es tan simple como poner la anotación
	// @Id sobre la propiedad que sería el ID de la entidad.
	@Id
	// la anotación @GeneratedValue para obligar a que el campo sea autoincremental
	// .
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer num_factura;
	// identificador para seleccionar la variable de tipo Date
	@Temporal(TemporalType.DATE)
	public Date fecha;

	// la anotación @ManyToOne , la cual nos permite mapear una entidad con otra.
	// Como única regla, es necesario la clase que sea una entidad, es decir, que
	// también esté anotada con @Entity .
	@ManyToOne(fetch = FetchType.LAZY)
	// Mediante la anotación @JoinColumn es posible personalizar las columnas que
	// será utilizadas como uniones con otras tablas.
	@JoinColumn(name = "id_cliente", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;

	// Las relaciones uno a muchos (@OneToMany) se caracterizan por Entidad donde
	// tenemos un objeto principal y colección de objetos de otra Entidad
	// relacionados directamente.
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
	private Set<Detalle> detalles = new HashSet<>();

	// constructor vacio
	public Factura() {

	}

	//get y sett de cada variable utilizada anteriormente
	public Integer getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(Integer num_factura) {
		this.num_factura = num_factura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@JsonIgnore
	public Cliente getCliente() {
		return cliente;
	}

	@JsonIgnore
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}

}
