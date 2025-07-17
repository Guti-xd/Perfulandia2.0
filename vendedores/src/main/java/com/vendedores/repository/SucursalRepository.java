package com.vendedores.repository;

import com.vendedores.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}