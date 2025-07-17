package com.reportes.service;

import com.reportes.models.KPls;
import com.reportes.repository.KPlsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class KPlsService {

    @Autowired 
    private KPlsRepository kplsRepository;

    public List<KPls> getAll() {
        return kplsRepository.findAll(); 
    }

    // Buscar 
    public KPls getById(Integer id) {
        Optional<KPls> kpls = kplsRepository.findById(id); 
        return kpls.orElse(null); 
    }

    // Crear   
    public KPls add(KPls kpls) {
        return kplsRepository.save(kpls); // Guarda y retorna   
    }

    // Actualizar 
    public KPls update(Integer id, KPls kpls) {
        if (kplsRepository.existsById(id)) {
            kpls.setIdreportes(id); // Aseguramos que se use el mismo ID
            return kplsRepository.save(kpls); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public KPls delete(Integer id) {
        Optional<KPls> kpls = kplsRepository.findById(id);
        if (kpls.isPresent()) {
            kplsRepository.deleteById(id); // Elimina 
            return kpls.get(); // Retorna 
        }
        return null; 
    }
}