package com.vendedores.controller;

import com.vendedores.models.Sucursal;
import com.vendedores.service.SucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/vendedores/sucursal") // Ruta base para este controlador
public class SucursalController {

    @Autowired // Inyección del servicio
    private SucursalService sucursalService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Sucursal>> getAll() {
        return ResponseEntity.ok(sucursalService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Sucursal sucursal = sucursalService.getById(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sucursal no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Sucursal sucursal) {
        Sucursal nueva = sucursalService.add(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        Sucursal actualizada = sucursalService.update(id, sucursal);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sucursal no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Sucursal eliminada = sucursalService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sucursal no encontrada");
        }
    }
}