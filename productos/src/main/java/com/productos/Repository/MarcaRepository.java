package com.productos.Repository;

import com.productos.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
