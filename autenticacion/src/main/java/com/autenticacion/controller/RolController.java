package com.autenticacion.controller;

import com.autenticacion.models.Rol;
import com.autenticacion.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/autenticacion/rol") // Ruta 
public class RolController {

    @Autowired 
    private RolService rolService;

    // Obtener todos   (GET)
    @GetMapping
    public ResponseEntity<List<Rol>> getAll() {
        return ResponseEntity.ok(rolService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Rol rol = rolService.getById(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    }

    // Crear nuevo (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Rol rol) {
        Rol nueva = rolService.add(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Rol rol) {
        Rol actualizada = rolService.update(id, rol);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Rol eliminada = rolService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    }
}
