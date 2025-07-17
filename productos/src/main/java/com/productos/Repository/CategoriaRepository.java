package com.productos.Repository;

import com.productos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
