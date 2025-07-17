package com.productos.service;

import com.productos.models.Marca;
import com.productos.Repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class MarcaService {

    @Autowired 
    private MarcaRepository marcaRepository;

    // Obtener todas
    public List<Marca> getAll() {
        return marcaRepository.findAll(); 
    }

    // Buscar 
    public Marca getById(Integer id) {
        Optional<Marca> marca = marcaRepository.findById(id); // Busca por ID
        return marca.orElse(null); 
    }

    // Crear 
    public Marca add(Marca marca) {
        return marcaRepository.save(marca); // Guarda y retorna 
    }

    // Actualizar 
    public Marca update(Integer id, Marca marca) {
        if (marcaRepository.existsById(id)) {
            marca.setIdMarca(id); // Aseguramos que se use el mismo ID
            return marcaRepository.save(marca); // Guarda los cambios
        }
        return null; // No se encontró la persona
    }

    // Eliminar una por ID
    public Marca delete(Integer id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        if (marca.isPresent()) {
            marcaRepository.deleteById(id); 
            return marca.get(); // Retorna la eliminada
        }
        return null; // No existe
    }
}