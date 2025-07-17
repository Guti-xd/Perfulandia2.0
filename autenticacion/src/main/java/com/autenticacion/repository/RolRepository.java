package com.autenticacion.repository;

import com.autenticacion.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
