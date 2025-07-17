package com.reportes.service;

import com.reportes.models.ResumenVentas;
import com.reportes.repository.ResumenVentasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ResumenVentasService {

    @Autowired 
    private ResumenVentasRepository resumenventasRepository;

    public List<ResumenVentas> getAll() {
        return resumenventasRepository.findAll(); 
    }

    // Buscar 
    public ResumenVentas getById(Integer id) {
        Optional<ResumenVentas> resumenventas = resumenventasRepository.findById(id); 
        return resumenventas.orElse(null); 
    }

    // Crear   
    public ResumenVentas add(ResumenVentas resumenventas) {
        return resumenventasRepository.save(resumenventas); // Guarda y retorna   
    }

    // Actualizar 
    public ResumenVentas update(Integer id, ResumenVentas resumenventas) {
        if (resumenventasRepository.existsById(id)) {
            resumenventas.setIdresumenV(id); // Aseguramos que se use el mismo ID
            return resumenventasRepository.save(resumenventas); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public ResumenVentas delete(Integer id) {
        Optional<ResumenVentas> resumenventas = resumenventasRepository.findById(id);
        if (resumenventas.isPresent()) {
            resumenventasRepository.deleteById(id); // Elimina 
            return resumenventas.get(); // Retorna 
        }
        return null; 
    }
}