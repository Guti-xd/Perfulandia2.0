package com.autenticacion.service;

import com.autenticacion.models.Rol;
import com.autenticacion.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class RolService {

    @Autowired 
    private RolRepository rolRepository;

    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    // Buscar
    public Rol getById(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id); 
        return rol.orElse(null); 
    }

    // Crear
    public Rol add(Rol rol) {
        return rolRepository.save(rol); 
    }

    // Actualizar 
    public Rol update(Integer id, Rol rol) {
        if (rolRepository.existsById(id)) {
            rol.setIdRol(id); 
            return rolRepository.save(rol); 
        }
        return null; 
    }

    // Eliminar
    public Rol delete(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            rolRepository.deleteById(id); // Elimina 
            return rol.get(); 
        }
        return null; 
    }
}
