package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.models.DetalleVenta;

@Repository 
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}
