package com.inventario.controller;

import com.inventario.models.MovimientoInventario;
import com.inventario.service.MovimientoInventarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/inventario/movimiento_inventario") // Ruta base para este controlador
public class MovimientoInventarioController {

    @Autowired // Inyección del servicio
    private MovimientoInventarioService movimientoinventarioService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> getAll() {
        return ResponseEntity.ok(movimientoinventarioService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        MovimientoInventario movimientoinventario = movimientoinventarioService.getById(id);
        if (movimientoinventario != null) {
            return ResponseEntity.ok(movimientoinventario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movimiento de inventario no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody MovimientoInventario movimientoinventario) {
        MovimientoInventario nueva = movimientoinventarioService.add(movimientoinventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody MovimientoInventario movimientoinventario) {
        MovimientoInventario actualizada = movimientoinventarioService.update(id, movimientoinventario);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movimiento de inventario no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        MovimientoInventario eliminada = movimientoinventarioService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movimiento de inventario no encontrada");
        }
    }
}