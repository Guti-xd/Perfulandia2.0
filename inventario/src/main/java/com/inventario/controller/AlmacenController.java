package com.inventario.controller;

import com.inventario.models.Almacen;
import com.inventario.service.AlmacenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/inventario/almacen") // Ruta base para este controlador
public class AlmacenController {

    @Autowired // Inyección del servicio
    private AlmacenService almacenService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Almacen>> getAll() {
        return ResponseEntity.ok(almacenService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Almacen almacen = almacenService.getById(id);
        if (almacen != null) {
            return ResponseEntity.ok(almacen);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("almacen no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Almacen almacen) {
        Almacen nueva = almacenService.add(almacen);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Almacen almacen) {
        Almacen actualizada = almacenService.update(id, almacen);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("almacen no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Almacen eliminada = almacenService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("almacen no encontrada");
        }
    }
}