package com.envios.service;

import com.envios.models.Transportista;
import com.envios.repository.TransportistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TransportistaService {

    @Autowired 
    private TransportistaRepository transportistaRepository;

    public List<Transportista> getAll() {
        return transportistaRepository.findAll(); 
    }

    // Buscar 
    public Transportista getById(Integer id) {
        Optional<Transportista> transportista = transportistaRepository.findById(id); 
        return transportista.orElse(null); 
    }

    // Crear   
    public Transportista add(Transportista transportista) {
        return transportistaRepository.save(transportista); // Guarda y retorna   
    }

    // Actualizar 
    public Transportista update(Integer id, Transportista transportista) {
        if (transportistaRepository.existsById(id)) {
            transportista.setIdTransportista(id); // Aseguramos que se use el mismo ID
            return transportistaRepository.save(transportista); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Transportista delete(Integer id) {
        Optional<Transportista> transportista = transportistaRepository.findById(id);
        if (transportista.isPresent()) {
            transportistaRepository.deleteById(id); // Elimina 
            return transportista.get(); // Retorna 
        }
        return null; 
    }
}