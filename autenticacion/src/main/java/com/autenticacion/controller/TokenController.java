package com.autenticacion.controller;

import com.autenticacion.models.Token;
import com.autenticacion.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/autenticacion/token") // Ruta 
public class TokenController {

    @Autowired 
    private TokenService tokenService;

    // Obtener todos   (GET)
    @GetMapping
    public ResponseEntity<List<Token>> getAll() {
        return ResponseEntity.ok(tokenService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Token token = tokenService.getById(id);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token no encontrado");
        }
    }

    // Crear nuevo (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Token token) {
        Token nueva = tokenService.add(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Token token) {
        Token actualizada = tokenService.update(id, token);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token no encontrado");
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Token eliminada = tokenService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token no encontrado");
        }
    }
}