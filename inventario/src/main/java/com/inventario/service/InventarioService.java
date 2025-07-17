package com.inventario.service;

import com.inventario.models.Inventario;
import com.inventario.repository.InventarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class InventarioService {

    @Autowired 
    private InventarioRepository inventarioRepository;

    public List<Inventario> getAll() {
        return inventarioRepository.findAll(); 
    }

    // Buscar 
    public Inventario getById(Integer id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id); 
        return inventario.orElse(null); 
    }

    // Crear   
    public Inventario add(Inventario inventario) {
        return inventarioRepository.save(inventario); // Guarda y retorna   
    }

    // Actualizar 
    public Inventario update(Integer id, Inventario inventario) {
        if (inventarioRepository.existsById(id)) {
            inventario.setIdInventario(id); // Aseguramos que se use el mismo ID
            return inventarioRepository.save(inventario); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Inventario delete(Integer id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        if (inventario.isPresent()) {
            inventarioRepository.deleteById(id); // Elimina 
            return inventario.get(); // Retorna 
        }
        return null; 
    }}