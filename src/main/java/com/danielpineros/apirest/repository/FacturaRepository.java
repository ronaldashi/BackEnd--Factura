package com.danielpineros.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielpineros.apirest.model.Factura;

@Repository
//interface factura mediante la clave integer de factura
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
	
	

}
