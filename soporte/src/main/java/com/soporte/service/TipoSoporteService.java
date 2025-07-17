package com.soporte.service;

import com.soporte.models.TipoSoporte;
import com.soporte.repository.TipoSoporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TipoSoporteService {

    @Autowired 
    private TipoSoporteRepository tiposoporteRepository;

    public List<TipoSoporte> getAll() {
        return tiposoporteRepository.findAll(); 
    }

    // Buscar 
    public TipoSoporte getById(Integer id) {
        Optional<TipoSoporte> tiposoporte = tiposoporteRepository.findById(id); 
        return tiposoporte.orElse(null); 
    }

    // Crear   
    public TipoSoporte add(TipoSoporte tiposoporte) {
        return tiposoporteRepository.save(tiposoporte); // Guarda y retorna   
    }

    // Actualizar 
    public TipoSoporte update(Integer id, TipoSoporte tiposoporte) {
        if (tiposoporteRepository.existsById(id)) {
            tiposoporte.setIdSoporte(id); // Aseguramos que se use el mismo ID
            return tiposoporteRepository.save(tiposoporte); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public TipoSoporte delete(Integer id) {
        Optional<TipoSoporte> tiposoporte = tiposoporteRepository.findById(id);
        if (tiposoporte.isPresent()) {
            tiposoporteRepository.deleteById(id); // Elimina 
            return tiposoporte.get(); // Retorna 
        }
        return null; 
    }
}