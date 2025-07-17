package com.envios.repository;

import com.envios.models.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TransportistaRepository extends JpaRepository<Transportista, Integer> {
}