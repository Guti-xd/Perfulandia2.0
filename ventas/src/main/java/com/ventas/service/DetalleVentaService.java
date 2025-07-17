package com.ventas.service;

import com.ventas.models.DetalleVenta;
import com.ventas.repository.DetalleVentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class DetalleVentaService {

    @Autowired 
    private DetalleVentaRepository detalleventaRepository;

    public List<DetalleVenta> getAll() {
        return detalleventaRepository.findAll(); 
    }

    // Buscar 
    public DetalleVenta getById(Integer id) {
        Optional<DetalleVenta> detalleventa = detalleventaRepository.findById(id); 
        return detalleventa.orElse(null); 
    }

    // Crear   
    public DetalleVenta add(DetalleVenta detalleventa) {
        return detalleventaRepository.save(detalleventa); // Guarda y retorna   
    }

    // Actualizar 
    public DetalleVenta update(Integer id, DetalleVenta detalleventa) {
        if (detalleventaRepository.existsById(id)) {
            detalleventa.setIddetalleV(id); // Aseguramos que se use el mismo ID
            return detalleventaRepository.save(detalleventa); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public DetalleVenta delete(Integer id) {
        Optional<DetalleVenta> detalleventa = detalleventaRepository.findById(id);
        if (detalleventa.isPresent()) {
            detalleventaRepository.deleteById(id); // Elimina 
            return detalleventa.get(); // Retorna 
        }
        return null; 
    }
}