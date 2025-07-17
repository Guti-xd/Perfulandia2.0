package com.ventas.controller;

import com.ventas.models.Cupon;
import com.ventas.service.CuponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/ventas/cupon") // Ruta base para este controlador
public class CuponController {

    @Autowired // Inyección del servicio
    private CuponService cuponService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Cupon>> getAll() {
        return ResponseEntity.ok(cuponService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Cupon cupon = cuponService.getById(id);
        if (cupon != null) {
            return ResponseEntity.ok(cupon);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cupon de venta no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Cupon cupon) {
        Cupon nueva = cuponService.add(cupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cupon cupon) {
        Cupon actualizada = cuponService.update(id, cupon);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cupon de venta no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Cupon eliminada = cuponService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cupon de venta no encontrada");
        }
    }
}