package com.autenticacion.service;

import com.autenticacion.models.Token;
import com.autenticacion.repository.TokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TokenService {

    @Autowired 
    private TokenRepository tokenRepository;

    public List<Token> getAll() {
        return tokenRepository.findAll();
    }

    // Buscar
    public Token getById(Integer id) {
        Optional<Token> token = tokenRepository.findById(id); 
        return token.orElse(null); 
    }

    // Crear
    public Token add(Token rol) {
        return tokenRepository.save(rol); 
    }

    // Actualizar 
    public Token update(Integer id, Token token) {
        if (tokenRepository.existsById(id)) {
            token.setIdToken(id);
            return tokenRepository.save(token); 
        }
        return null; 
    }

    // Eliminar
    public Token delete(Integer id) {
        Optional<Token> token = tokenRepository.findById(id);
        if (token.isPresent()) {
            tokenRepository.deleteById(id); // Elimina 
            return token.get(); 
        }
        return null; 
    }
}