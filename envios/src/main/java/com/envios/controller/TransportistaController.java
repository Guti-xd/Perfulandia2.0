package com.envios.controller;

import com.envios.models.Transportista;
import com.envios.service.TransportistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Importaciones para HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/transportista") // Ruta base para este controlador
public class TransportistaController {

    @Autowired 
    private TransportistaService transportistaService;

    // Obtener todas las (GET)
    @GetMapping
    public ResponseEntity<List<Transportista>> getAll() {
        return ResponseEntity.ok(transportistaService.getAll());
    }

    // Obtener por ID con HATEOAS (GET)
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Transportista>> getById(@PathVariable Integer id) {
        Transportista transportista = transportistaService.getById(id);
        if (transportista == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<Transportista> recurso = EntityModel.of(transportista,
            linkTo(methodOn(TransportistaController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(TransportistaController.class).getAll()).withRel("transportistas")
        );

        return ResponseEntity.ok(recurso);
    }

    // Crear nuevo (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Transportista transportista) {
        Transportista nueva = transportistaService.add(transportista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Transportista transportista) {
        Transportista actualizada = transportistaService.update(id, transportista);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transportista no encontrado");
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Transportista eliminada = transportistaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transportista no encontrado");
        }
    }
}
