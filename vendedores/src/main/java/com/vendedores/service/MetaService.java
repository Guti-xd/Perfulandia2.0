package com.vendedores.service;

import com.vendedores.models.Meta;
import com.vendedores.repository.MetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class MetaService {

    @Autowired 
    private MetaRepository metaRepository;

    public List<Meta> getAll() {
        return metaRepository.findAll(); 
    }

    // Buscar 
    public Meta getById(Integer id) {
        Optional<Meta> meta = metaRepository.findById(id); 
        return meta.orElse(null); 
    }

    // Crear   
    public Meta add(Meta meta) {
        return metaRepository.save(meta); // Guarda y retorna   
    }

    // Actualizar 
    public Meta update(Integer id, Meta meta) {
        if (metaRepository.existsById(id)) {
            meta.setIdMeta(id);// Aseguramos que se use el mismo ID
            return metaRepository.save(meta); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Meta delete(Integer id) {
        Optional<Meta> meta = metaRepository.findById(id);
        if (meta.isPresent()) {
            metaRepository.deleteById(id); // Elimina 
            return meta.get(); // Retorna 
        }
        return null; 
    }
}