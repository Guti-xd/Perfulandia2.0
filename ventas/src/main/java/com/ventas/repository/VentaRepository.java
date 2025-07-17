package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.models.Venta;

@Repository 
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
