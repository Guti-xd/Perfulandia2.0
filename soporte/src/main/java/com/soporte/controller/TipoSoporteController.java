package com.soporte.controller;

import com.soporte.models.TipoSoporte;
import com.soporte.service.TipoSoporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/soporte/tiposoporte") // Ruta base para este controlador
public class TipoSoporteController {

    @Autowired // Inyección del servicio
    private TipoSoporteService tiposoporteService;

    // Obtener todos (GET)
    @GetMapping
    public ResponseEntity<List<TipoSoporte>> getAll() {
        return ResponseEntity.ok(tiposoporteService.getAll());
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        TipoSoporte tiposoporte = tiposoporteService.getById(id);
        if (tiposoporte != null) {
            return ResponseEntity.ok(tiposoporte);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo de soporte no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody TipoSoporte tiposoporte) {
        TipoSoporte nueva = tiposoporteService.add(tiposoporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TipoSoporte tiposoporte) {
        TipoSoporte actualizada = tiposoporteService.update(id, tiposoporte);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo de soporte no encontrada");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        TipoSoporte eliminada = tiposoporteService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo de soporte no encontrada");
        }
    }
}

