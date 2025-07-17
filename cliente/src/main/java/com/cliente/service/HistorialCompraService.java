package com.cliente.service;

import com.cliente.models.HistorialCompra;
import com.cliente.repository.HistorialCompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class HistorialCompraService {

    @Autowired 
    private HistorialCompraRepository historialcompraRepository;

    public List<HistorialCompra> getAll() {
        return historialcompraRepository.findAll(); 
    }

    // Buscar 
    public HistorialCompra getById(Integer id) {
        Optional<HistorialCompra> historialcompra = historialcompraRepository.findById(id); 
        return historialcompra.orElse(null); 
    }

    // Crear   
    public HistorialCompra add(HistorialCompra historialcompra) {
        return historialcompraRepository.save(historialcompra); // Guarda y retorna   
    }

    // Actualizar 
    public HistorialCompra update(Integer id, HistorialCompra historialcompra) {
        if (historialcompraRepository.existsById(id)) {
            historialcompra.setIdHistorialCompra(id); // Aseguramos que se use el mismo ID
            return historialcompraRepository.save(historialcompra); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public HistorialCompra delete(Integer id) {
        Optional<HistorialCompra> historialcompra = historialcompraRepository.findById(id);
        if (historialcompra.isPresent()) {
            historialcompraRepository.deleteById(id); // Elimina 
            return historialcompra.get(); // Retorna 
        }
        return null; 
    }}