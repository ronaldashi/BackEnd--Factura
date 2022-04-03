//paquete en el cual se guarda todos los controles de cada clase 
package com.danielpineros.apirest.model;

//liberias importadas para la cardinalidad entre tablas
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//librerias para los apuntadores de cada metodo
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//es una clase de Java ligera, cuyo estado es persistido de manera asociada a una tabla en una base de datos relacional
@Entity
//@Table se usará para nombrar la tabla en la base de datos
@Table(name = "Productos")
//Java facilita el almacenamiento y transmisión del estado de un objeto mediante un mecanismo conocido con el nombre de serialización
public class Productos implements Serializable {

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "id_producto", nullable = false, length = 10)
	// Para determinar el ID de una entidad es tan simple como poner la anotación
	// @Id sobre la propiedad que sería el ID de la entidad.
	@Id
	// la anotación @GeneratedValue para obligar a que el campo sea autoincremental
	// .
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_producto;

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "nombre")
	public String nombre;

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "precio")
	public String precio;

	// La anotación @Column nos permitirá definir aspectos muy importantes sobre las
	// columnas de la base de datos de la base de datos como lo es el nombre, la
	// longitud, constrains, etc
	@Column(name = "stock")
	public String stock;

	// Las relaciones uno a muchos (@OneToMany) se caracterizan por Entidad donde
	// tenemos un objeto principal y colección de objetos de otra Entidad
	// relacionados directamente.
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private Set<Detalle> detalles = new HashSet<>();

	//contructor vacio
	public Productos() {

	}

	//get y sett de cada variable utilizada anteriormente
	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Set<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
				+ ", detalles=" + detalles + "]";
	}

}
