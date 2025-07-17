package com.cliente.repository;

import com.cliente.models.HistorialCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface HistorialCompraRepository extends JpaRepository<HistorialCompra, Integer> {
}
