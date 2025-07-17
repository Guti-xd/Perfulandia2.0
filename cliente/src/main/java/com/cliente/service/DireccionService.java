package com.cliente.service;

import com.cliente.models.Direccion;
import com.cliente.repository.DireccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class DireccionService {

    @Autowired 
    private DireccionRepository direccionRepository;

    public List<Direccion> getAll() {
        return direccionRepository.findAll(); 
    }

    // Buscar 
    public Direccion getById(Integer id) {
        Optional<Direccion> direccion = direccionRepository.findById(id); 
        return direccion.orElse(null); 
    }

    // Crear   
    public Direccion add(Direccion direccion) {
        return direccionRepository.save(direccion); // Guarda y retorna   
    }

    // Actualizar 
    public Direccion update(Integer id, Direccion direccion) {
        if (direccionRepository.existsById(id)) {
            direccion.setIdDireccion(id); // Aseguramos que se use el mismo ID
            return direccionRepository.save(direccion); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Direccion delete(Integer id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        if (direccion.isPresent()) {
            direccionRepository.deleteById(id); // Elimina 
            return direccion.get(); // Retorna 
        }
        return null; 
    }
}