package com.productos.controller;

import com.productos.models.Categoria;
import com.productos.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/productos/categoria") // Ruta
public class CategoriaController {

    @Autowired // Inyección del servicio
    private CategoriaService categoriaService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.getById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria no encontrado");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Categoria categoria) {
        Categoria nueva = categoriaService.add(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        Categoria actualizada = categoriaService.update(id, categoria);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria no encontrado");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Categoria eliminada = categoriaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("categoria no encontrado");
        }
    }
}