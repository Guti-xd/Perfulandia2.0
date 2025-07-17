package com.ventas.controller;

import com.ventas.models.DetalleVenta;
import com.ventas.service.DetalleVentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/ventas/detalle_venta") // Ruta base para este controlador
public class DetalleVentaController {

    @Autowired // Inyección del servicio
    private DetalleVentaService detalleventaService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> getAll() {
        return ResponseEntity.ok(detalleventaService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        DetalleVenta detalleventa = detalleventaService.getById(id);
        if (detalleventa != null) {
            return ResponseEntity.ok(detalleventa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("detalle de venta no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody DetalleVenta detalleventa) {
        DetalleVenta nueva = detalleventaService.add(detalleventa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DetalleVenta detalleventa) {
        DetalleVenta actualizada = detalleventaService.update(id, detalleventa);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("detalle de venta no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        DetalleVenta eliminada = detalleventaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("detalle de venta no encontrada");
        }
    }
}


