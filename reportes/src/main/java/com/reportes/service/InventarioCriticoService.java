package com.reportes.service;

import com.reportes.models.InventarioCritico;
import com.reportes.repository.InventarioCriticoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class InventarioCriticoService {

    @Autowired 
    private InventarioCriticoRepository inventariocriticoRepository;

    public List<InventarioCritico> getAll() {
        return inventariocriticoRepository.findAll(); 
    }

    // Buscar 
    public InventarioCritico getById(Integer id) {
        Optional<InventarioCritico> inventariocritico = inventariocriticoRepository.findById(id); 
        return inventariocritico.orElse(null); 
    }

    // Crear   
    public InventarioCritico add(InventarioCritico inventariocritico) {
        return inventariocriticoRepository.save(inventariocritico); // Guarda y retorna   
    }

    // Actualizar 
    public InventarioCritico update(Integer id, InventarioCritico inventariocritico) {
        if (inventariocriticoRepository.existsById(id)) {
            inventariocritico.setIdinventarioC(id); // Aseguramos que se use el mismo ID
            return inventariocriticoRepository.save(inventariocritico); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public InventarioCritico delete(Integer id) {
        Optional<InventarioCritico> inventariocritico = inventariocriticoRepository.findById(id);
        if (inventariocritico.isPresent()) {
            inventariocriticoRepository.deleteById(id); // Elimina 
            return inventariocritico.get(); // Retorna 
        }
        return null; 
    }
}