package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.models.Cupon;

@Repository 
public interface CuponRepository extends JpaRepository<Cupon, Integer> {
}
