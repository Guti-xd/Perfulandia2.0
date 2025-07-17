package com.ventas.service;

import com.ventas.models.Venta;
import com.ventas.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class VentaService {

    @Autowired 
    private VentaRepository ventaRepository;

    public List<Venta> getAll() {
        return ventaRepository.findAll(); 
    }

    // Buscar 
    public Venta getById(Integer id) {
        Optional<Venta> venta = ventaRepository.findById(id); 
        return venta.orElse(null); 
    }

    // Crear   
    public Venta add(Venta venta) {
        return ventaRepository.save(venta); // Guarda y retorna   
    }

    // Actualizar 
    public Venta update(Integer id, Venta venta) {
        if (ventaRepository.existsById(id)) {
            venta.setIdVenta(id); // Aseguramos que se use el mismo ID
            return ventaRepository.save(venta); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Venta delete(Integer id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            ventaRepository.deleteById(id); // Elimina 
            return venta.get(); // Retorna 
        }
        return null; 
    }
}