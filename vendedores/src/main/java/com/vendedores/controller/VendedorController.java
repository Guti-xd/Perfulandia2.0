package com.vendedores.controller;

import com.vendedores.models.Vendedor;
import com.vendedores.service.VendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/vendedores/vendedor") // Ruta base para este controlador
public class VendedorController {

    @Autowired // Inyección del servicio
    private VendedorService vendedorService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Vendedor>> getAll() {
        return ResponseEntity.ok(vendedorService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Vendedor vendedor = vendedorService.getById(id);
        if (vendedor != null) {
            return ResponseEntity.ok(vendedor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vendedor no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Vendedor vendedor) {
        Vendedor nueva = vendedorService.add(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        Vendedor actualizada = vendedorService.update(id, vendedor);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vendedor no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Vendedor eliminada = vendedorService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vendedor no encontrada");
        }
    }
}
