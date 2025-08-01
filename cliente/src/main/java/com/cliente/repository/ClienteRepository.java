package com.cliente.repository;

import com.cliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
