package com.inventario.repository;

import com.inventario.models.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
}

