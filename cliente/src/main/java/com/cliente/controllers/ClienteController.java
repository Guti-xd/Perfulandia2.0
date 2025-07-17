package com.cliente.controllers;

import com.cliente.models.Cliente;
import com.cliente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Importaciones para HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/cliente/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    // Método modificado para devolver HATEOAS
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> getById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Construcción del EntityModel con enlaces
        EntityModel<Cliente> recurso = EntityModel.of(cliente,
            linkTo(methodOn(ClienteController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(ClienteController.class).getAll()).withRel("clientes")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Cliente cliente) {
        Cliente nueva = clienteService.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente actualizada = clienteService.update(id, cliente);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Cliente eliminada = clienteService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}
