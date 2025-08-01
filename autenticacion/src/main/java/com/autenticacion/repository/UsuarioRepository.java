package com.autenticacion.repository;

import com.autenticacion.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}