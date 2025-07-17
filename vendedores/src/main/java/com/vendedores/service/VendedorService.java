package com.vendedores.service;

import com.vendedores.models.Vendedor;
import com.vendedores.repository.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class VendedorService {

    @Autowired 
    private VendedorRepository vendedorRepository;

    public List<Vendedor> getAll() {
        return vendedorRepository.findAll(); 
    }

    // Buscar 
    public Vendedor getById(Integer id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id); 
        return vendedor.orElse(null); 
    }

    // Crear   
    public Vendedor add(Vendedor vendedor) {
        return vendedorRepository.save(vendedor); // Guarda y retorna   
    }

    // Actualizar 
    public Vendedor update(Integer id, Vendedor vendedor) {
        if (vendedorRepository.existsById(id)) {
            vendedor.setIdVendedor(id);// Aseguramos que se use el mismo ID
            return vendedorRepository.save(vendedor); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Vendedor delete(Integer id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        if (vendedor.isPresent()) {
            vendedorRepository.deleteById(id); // Elimina 
            return vendedor.get(); // Retorna 
        }
        return null; 
    }
}