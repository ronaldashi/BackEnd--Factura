package com.danielpineros.apirest.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	@Column(name = "id_cliente", nullable = false, length = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_cliente;

	@Column(name = "nombre")
	public String nombre;

	@Column(name = "apellidos")
	public String apellidos;

	@Column(name = "telefono")
	public Double telefono;
		
	@Temporal(TemporalType.DATE)
	public Date fecha_nacimiento;
	
	@Column(name = "email")
	public String email;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Factura> facturas = new HashSet<>();

	public Cliente() {
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Double getTelefono() {
		return telefono;
	}

	public void setTelefono(Double telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", email=" + email + ", facturas=" + facturas
				+ "]";
	}

}
