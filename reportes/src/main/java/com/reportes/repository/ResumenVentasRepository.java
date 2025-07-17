package com.reportes.repository;

import com.reportes.models.ResumenVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ResumenVentasRepository extends JpaRepository<ResumenVentas, Integer> {
}
