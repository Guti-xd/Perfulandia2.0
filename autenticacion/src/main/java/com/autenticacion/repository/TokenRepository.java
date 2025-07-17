package com.autenticacion.repository;

import com.autenticacion.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TokenRepository extends JpaRepository<Token, Integer> {
}