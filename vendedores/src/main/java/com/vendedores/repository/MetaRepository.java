package com.vendedores.repository;

import com.vendedores.models.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface MetaRepository extends JpaRepository<Meta, Integer> {
}