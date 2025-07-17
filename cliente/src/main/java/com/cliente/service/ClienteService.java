package com.cliente.service;

import com.cliente.models.Cliente;
import com.cliente.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ClienteService {

    @Autowired // Inyecta automáticamente la dependencia del repositorio
    private ClienteRepository clienteRepository;

    // Obtener todas las personas desde la base de datos
    public List<Cliente> getAll() {
        return clienteRepository.findAll(); // Devuelve lista de personas
    }

    // Buscar una persona por su ID
    public Cliente getById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id); // Busca por ID
        return cliente.orElse(null); // Si no la encuentra, retorna null
    }

    // Crear una nueva persona
    public Cliente add(Cliente cliente) {
        return clienteRepository.save(cliente); // Guarda y retorna la nueva persona
    }

    // Actualizar una persona existente
    public Cliente update(Integer id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setIdCliente(id); // Aseguramos que se use el mismo ID
            return clienteRepository.save(cliente); // Guarda los cambios
        }
        return null; // No se encontró la persona
    }

    // Eliminar una persona por ID
    public Cliente delete(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            clienteRepository.deleteById(id); // Elimina la persona
            return cliente.get(); // Retorna la persona eliminada
        }
        return null; // No existe la persona
    }
}
