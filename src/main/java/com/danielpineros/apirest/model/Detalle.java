//paquete en el cual se guarda todos los controles de cada clase 
package com.danielpineros.apirest.model;

//liberias importadas para la cardinalidad entre tablas
import java.io.Serializable;

//librerias para los apuntadores de cada metodo
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

//es una clase de Java ligera, cuyo estado es persistido de manera asociada a una tabla en una base de datos relacional
@Entity
//@Table se usará para nombrar la tabla en la base de datos
@Table(name = "Detalle")
//Java facilita el almacenamiento y transmisión del estado de un objeto mediante un mecanismo conocido con el nombre de serialización
public class Detalle implements Serializable {

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "num_detalle", nullable = false, length = 10)
	// Para determinar el ID de una entidad es tan simple como poner la anotación
	// @Id sobre la propiedad que sería el ID de la entidad.
	@Id
	// la anotación @GeneratedValue para obligar a que el campo sea autoincremental

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer num_detalle;

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "cantidad")
	private Integer cantidad;

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "precio")
	private Double precio;

	// la anotación @ManyToOne , la cual nos permite mapear una entidad con otra.
	// Como única regla, es necesario la clase que sea una entidad, es decir, que
	// también esté anotada con @Entity .
	@ManyToOne(fetch = FetchType.LAZY)
	// Mediante la anotación @JoinColumn es posible personalizar las columnas que
	// será utilizadas como uniones con otras tablas.
	@JoinColumn(name = "num_factura", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Factura factura;

	// la anotación @ManyToOne , la cual nos permite mapear una entidad con otra.
	// Como única regla, es necesario la clase que sea una entidad, es decir, que
	// también esté anotada con @Entity .
	@ManyToOne(fetch = FetchType.LAZY)
	// Mediante la anotación @JoinColumn es posible personalizar las columnas que
	// será utilizadas como uniones con otras tablas.
	@JoinColumn(name = "id_producto", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Productos producto;

	//constructor vacio
	public Detalle() {

	}

	//get y sett de cada variable utilizada anteriormente
	public Integer getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(Integer num_detalle) {
		this.num_detalle = num_detalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@JsonIgnore
	public Factura getFactura() {
		return factura;
	}

	@JsonIgnore
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@JsonIgnore
	public Productos getProducto() {
		return producto;
	}

	@JsonIgnore
	public void setProducto(Productos producto) {
		this.producto = producto;
	}

}
