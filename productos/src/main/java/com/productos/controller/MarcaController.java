package com.productos.controller;

import com.productos.models.Marca;
import com.productos.service.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/productos/marca") // Ruta
public class MarcaController {

    @Autowired // Inyección del servicio
    private MarcaService marcaService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Marca>> getAll() {
        return ResponseEntity.ok(marcaService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Marca marca = marcaService.getById(id);
        if (marca != null) {
            return ResponseEntity.ok(marca);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("marca no encontrado");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Marca marca) {
        Marca nueva = marcaService.add(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Marca marca) {
        Marca actualizada = marcaService.update(id, marca);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("marca no encontrado");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Marca eliminada = marcaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("marca no encontrado");
        }
    }
}
