package com.ventas.service;

import com.ventas.models.Cupon;
import com.ventas.repository.CuponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class CuponService {

    @Autowired 
    private CuponRepository cuponRepository;

    public List<Cupon> getAll() {
        return cuponRepository.findAll(); 
    }

    // Buscar 
    public Cupon getById(Integer id) {
        Optional<Cupon> cupon = cuponRepository.findById(id); 
        return cupon.orElse(null); 
    }

    // Crear   
    public Cupon add(Cupon cupon) {
        return cuponRepository.save(cupon); // Guarda y retorna   
    }

    // Actualizar 
    public Cupon update(Integer id, Cupon cupon) {
        if (cuponRepository.existsById(id)) {
            cupon.setIdcupon(id); // Aseguramos que se use el mismo ID
            return cuponRepository.save(cupon); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Cupon delete(Integer id) {
        Optional<Cupon> cupon = cuponRepository.findById(id);
        if (cupon.isPresent()) {
            cuponRepository.deleteById(id); // Elimina 
            return cupon.get(); // Retorna 
        }
        return null; 
    }
}