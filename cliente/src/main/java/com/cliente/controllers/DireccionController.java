package com.cliente.controllers;

import com.cliente.models.Direccion;
import com.cliente.service.DireccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/cliente/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAll() {
        return ResponseEntity.ok(direccionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Direccion>> getById(@PathVariable Integer id) {
        Direccion direccion = direccionService.getById(id);
        if (direccion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<Direccion> recurso = EntityModel.of(direccion,
            linkTo(methodOn(DireccionController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(DireccionController.class).getAll()).withRel("direcciones")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Direccion direccion) {
        Direccion nueva = direccionService.add(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Direccion direccion) {
        Direccion actualizada = direccionService.update(id, direccion);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("direccion no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Direccion eliminada = direccionService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("direccion no encontrada");
        }
    }
}
