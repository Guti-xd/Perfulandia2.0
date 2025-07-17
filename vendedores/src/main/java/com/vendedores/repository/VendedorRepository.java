package com.vendedores.repository;

import com.vendedores.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}