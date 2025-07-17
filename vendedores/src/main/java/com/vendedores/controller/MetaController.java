package com.vendedores.controller;

import com.vendedores.models.Meta;
import com.vendedores.service.MetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/vendedores/meta") // Ruta base para este controlador
public class MetaController {

    @Autowired // Inyección del servicio
    private MetaService metaService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Meta>> getAll() {
        return ResponseEntity.ok(metaService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Meta meta = metaService.getById(id);
        if (meta != null) {
            return ResponseEntity.ok(meta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("meta no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Meta meta) {
        Meta nueva = metaService.add(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Meta meta) {
        Meta actualizada = metaService.update(id, meta);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("meta no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Meta eliminada = metaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("meta no encontrada");
        }
    }
}