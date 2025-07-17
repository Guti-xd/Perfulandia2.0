package com.productos.service;


import com.productos.models.Categoria;
import com.productos.Repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class CategoriaService {

    @Autowired 
    private CategoriaRepository categoriaRepository;

    // Obtener todas
    public List<Categoria> getAll() {
        return categoriaRepository.findAll(); 
    }

    // Buscar 
    public Categoria getById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id); // Busca por ID
        return categoria.orElse(null); 
    }

    // Crear 
    public Categoria add(Categoria categoria) {
        return categoriaRepository.save(categoria); // Guarda y retorna 
    }

    // Actualizar 
    public Categoria update(Integer id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setIdCategoria(id); // Aseguramos que se use el mismo ID
            return categoriaRepository.save(categoria); // Guarda los cambios
        }
        return null; // No se encontró la persona
    }

    // Eliminar una por ID
    public Categoria delete(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id); 
            return categoria.get(); // Retorna la eliminada
        }
        return null; // No existe
    }
}