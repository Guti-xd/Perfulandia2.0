package com.productos.Repository;

import com.productos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
