package com.cliente.controllers;

import com.cliente.models.HistorialCompra;
import com.cliente.service.HistorialCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/cliente/historial_compra")
public class HistorialCompraController {

    @Autowired
    private HistorialCompraService historialcompraService;

    @GetMapping
    public ResponseEntity<List<HistorialCompra>> getAll() {
        return ResponseEntity.ok(historialcompraService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<HistorialCompra>> getById(@PathVariable Integer id) {
        HistorialCompra historial = historialcompraService.getById(id);
        if (historial == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<HistorialCompra> recurso = EntityModel.of(historial,
            linkTo(methodOn(HistorialCompraController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(HistorialCompraController.class).getAll()).withRel("historiales")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody HistorialCompra historial) {
        HistorialCompra nueva = historialcompraService.add(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody HistorialCompra historial) {
        HistorialCompra actualizada = historialcompraService.update(id, historial);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("historial de compra no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        HistorialCompra eliminada = historialcompraService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("historial de compra no encontrada");
        }
    }
}
