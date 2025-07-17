package com.reportes.controller;

import com.reportes.models.InventarioCritico;
import com.reportes.service.InventarioCriticoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/reportes/inventario_critico") // Ruta base para este controlador
public class InventarioCriticoController {

    @Autowired // Inyección del servicio
    private InventarioCriticoService inventariocriticoService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<InventarioCritico>> getAll() {
        return ResponseEntity.ok(inventariocriticoService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        InventarioCritico inventariocritico = inventariocriticoService.getById(id);
        if (inventariocritico != null) {
            return ResponseEntity.ok(inventariocritico);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ninguno");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody InventarioCritico inventariocritico) {
        InventarioCritico nueva = inventariocriticoService.add(inventariocritico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody InventarioCritico inventariocritico) {
        InventarioCritico actualizada = inventariocriticoService.update(id, inventariocritico);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ninguno");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        InventarioCritico eliminada = inventariocriticoService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ninguno");
        }
    }
}