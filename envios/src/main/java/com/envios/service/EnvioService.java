package com.envios.service;

import com.envios.models.Envio;
import com.envios.repository.EnvioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class EnvioService {

    @Autowired 
    private EnvioRepository envioRepository;

    public List<Envio> getAll() {
        return envioRepository.findAll(); 
    }

    // Buscar 
    public Envio getById(Integer id) {
        Optional<Envio> envio = envioRepository.findById(id); 
        return envio.orElse(null); 
    }

    // Crear   
    public Envio add(Envio envio) {
        return envioRepository.save(envio); // Guarda y retorna   
    }

    // Actualizar 
    public Envio update(Integer id, Envio envio) {
        if (envioRepository.existsById(id)) {
            envio.setIdEnvio(id); // Aseguramos que se use el mismo ID
            return envioRepository.save(envio); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Envio delete(Integer id) {
        Optional<Envio> envio = envioRepository.findById(id);
        if (envio.isPresent()) {
            envioRepository.deleteById(id); // Elimina 
            return envio.get(); // Retorna 
        }
        return null; 
    }
}