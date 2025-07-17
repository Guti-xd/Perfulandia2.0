package com.reportes.controller;

import com.reportes.models.KPls;
import com.reportes.service.KPlsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/reportes/KPls") // Ruta base para este controlador
public class KPlsController {

    @Autowired // Inyección del servicio
    private KPlsService kplsService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<KPls>> getAll() {
        return ResponseEntity.ok(kplsService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        KPls kpls = kplsService.getById(id);
        if (kpls != null) {
            return ResponseEntity.ok(kpls);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reoprte de cliente no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody KPls kpls) {
        KPls nueva = kplsService.add(kpls);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KPls kpls) {
        KPls actualizada = kplsService.update(id, kpls);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reoprte de cliente no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        KPls eliminada = kplsService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reoprte de cliente no encontrada");
        }
    }
}
