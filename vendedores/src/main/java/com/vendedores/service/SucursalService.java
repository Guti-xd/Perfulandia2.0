package com.vendedores.service;

import com.vendedores.models.Sucursal;
import com.vendedores.repository.SucursalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class SucursalService {

    @Autowired 
    private SucursalRepository sucursalRepository;

    public List<Sucursal> getAll() {
        return sucursalRepository.findAll(); 
    }

    // Buscar 
    public Sucursal getById(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id); 
        return sucursal.orElse(null); 
    }

    // Crear   
    public Sucursal add(Sucursal sucursal) {
        return sucursalRepository.save(sucursal); // Guarda y retorna   
    }

    // Actualizar 
    public Sucursal update(Integer id, Sucursal sucursal) {
        if (sucursalRepository.existsById(id)) {
            sucursal.setIdSucursal(id);// Aseguramos que se use el mismo ID
            return sucursalRepository.save(sucursal); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Sucursal delete(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if (sucursal.isPresent()) {
            sucursalRepository.deleteById(id); // Elimina 
            return sucursal.get(); // Retorna 
        }
        return null; 
    }
}