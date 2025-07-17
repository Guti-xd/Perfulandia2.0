package com.reportes.repository;

import com.reportes.models.InventarioCritico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface InventarioCriticoRepository extends JpaRepository<InventarioCritico, Integer> {
}
