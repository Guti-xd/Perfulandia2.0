package com.envios.repository;

import com.envios.models.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Integer> {
}