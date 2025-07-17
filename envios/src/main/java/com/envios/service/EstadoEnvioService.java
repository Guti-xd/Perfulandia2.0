package com.envios.service;

import com.envios.models.EstadoEnvio;
import com.envios.repository.EstadoEnvioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class EstadoEnvioService {

    @Autowired 
    private EstadoEnvioRepository estadoenvioRepository;

    public List<EstadoEnvio> getAll() {
        return estadoenvioRepository.findAll(); 
    }

    // Buscar 
    public EstadoEnvio getById(Integer id) {
        Optional<EstadoEnvio> estadoenvio = estadoenvioRepository.findById(id); 
        return estadoenvio.orElse(null); 
    }

    // Crear   
    public EstadoEnvio add(EstadoEnvio estadoenvio) {
        return estadoenvioRepository.save(estadoenvio); // Guarda y retorna   
    }

    // Actualizar 
    public EstadoEnvio update(Integer id, EstadoEnvio estadoenvio) {
        if (estadoenvioRepository.existsById(id)) {
            estadoenvio.setIdEstadoEnvio(id); // Aseguramos que se use el mismo ID
            return estadoenvioRepository.save(estadoenvio); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public EstadoEnvio delete(Integer id) {
        Optional<EstadoEnvio> estadoenvio = estadoenvioRepository.findById(id);
        if (estadoenvio.isPresent()) {
            estadoenvioRepository.deleteById(id); // Elimina 
            return estadoenvio.get(); // Retorna 
        }
        return null; 
    }
}
