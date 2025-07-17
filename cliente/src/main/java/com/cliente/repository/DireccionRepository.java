package com.cliente.repository;

import com.cliente.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
}