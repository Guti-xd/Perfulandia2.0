package com.inventario.service;

import com.inventario.models.MovimientoInventario;
import com.inventario.repository.MovimientoInventarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class MovimientoInventarioService {

    @Autowired 
    private MovimientoInventarioRepository movimientoInventarioRepositoryRepository;

    public List<MovimientoInventario> getAll() {
        return movimientoInventarioRepositoryRepository.findAll(); 
    }

    // Buscar 
    public MovimientoInventario getById(Integer id) {
        Optional<MovimientoInventario> movimientoInventarioRepository = movimientoInventarioRepositoryRepository.findById(id); 
        return movimientoInventarioRepository.orElse(null); 
    }

    // Crear   
    public MovimientoInventario add(MovimientoInventario movimientoInventarioRepository) {
        return movimientoInventarioRepositoryRepository.save(movimientoInventarioRepository); // Guarda y retorna   
    }

    // Actualizar 
    public MovimientoInventario update(Integer id, MovimientoInventario movimientoInventarioRepository) {
        if (movimientoInventarioRepositoryRepository.existsById(id)) {
            movimientoInventarioRepository.setIdMovimiento(id); // Aseguramos que se use el mismo ID
            return movimientoInventarioRepositoryRepository.save(movimientoInventarioRepository); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public MovimientoInventario delete(Integer id) {
        Optional<MovimientoInventario> movimientoInventarioRepository = movimientoInventarioRepositoryRepository.findById(id);
        if (movimientoInventarioRepository.isPresent()) {
            movimientoInventarioRepositoryRepository.deleteById(id); // Elimina 
            return movimientoInventarioRepository.get(); // Retorna 
        }
        return null; 
    }}