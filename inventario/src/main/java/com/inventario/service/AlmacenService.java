package com.inventario.service;

import com.inventario.models.Almacen;
import com.inventario.repository.AlmacenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class AlmacenService {

    @Autowired 
    private AlmacenRepository almacenRepository;

    public List<Almacen> getAll() {
        return almacenRepository.findAll(); 
    }

    // Buscar 
    public Almacen getById(Integer id) {
        Optional<Almacen> almacen = almacenRepository.findById(id); 
        return almacen.orElse(null); 
    }

    // Crear   
    public Almacen add(Almacen almacen) {
        return almacenRepository.save(almacen); // Guarda y retorna   
    }

    // Actualizar 
    public Almacen update(Integer id, Almacen almacen) {
        if (almacenRepository.existsById(id)) {
            almacen.setIdAlmacen(id); // Aseguramos que se use el mismo ID
            return almacenRepository.save(almacen); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Almacen delete(Integer id) {
        Optional<Almacen> almacen = almacenRepository.findById(id);
        if (almacen.isPresent()) {
            almacenRepository.deleteById(id); // Elimina 
            return almacen.get(); // Retorna 
        }
        return null; 
    }}

