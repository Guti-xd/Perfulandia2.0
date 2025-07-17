package com.inventario.repository;

import com.inventario.models.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}
