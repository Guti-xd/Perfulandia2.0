package com.soporte.repository;

import com.soporte.models.TipoSoporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TipoSoporteRepository extends JpaRepository<TipoSoporte, Integer> {
}