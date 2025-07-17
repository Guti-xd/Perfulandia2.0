package com.reportes.controller;

import com.reportes.models.ResumenVentas;
import com.reportes.service.ResumenVentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/reportes/resumen_ventas") // Ruta base para este controlador
public class ResumenVentasController {

    @Autowired // Inyección del servicio
    private ResumenVentasService resumenventasService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<ResumenVentas>> getAll() {
        return ResponseEntity.ok(resumenventasService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        ResumenVentas resumenventas = resumenventasService.getById(id);
        if (resumenventas != null) {
            return ResponseEntity.ok(resumenventas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin resumen de ventas");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ResumenVentas resumenventas) {
        ResumenVentas nueva = resumenventasService.add(resumenventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ResumenVentas resumenventas) {
        ResumenVentas actualizada = resumenventasService.update(id, resumenventas);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin resumen de ventas");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        ResumenVentas eliminada = resumenventasService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin resumen de ventas ");
        }
    }
}
