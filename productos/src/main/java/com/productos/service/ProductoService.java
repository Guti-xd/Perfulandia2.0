package com.productos.service;

import com.productos.models.Producto;
import com.productos.Repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ProductoService {

    @Autowired 
    private ProductoRepository productoRepository;

    // Obtener todas
    public List<Producto> getAll() {
        return productoRepository.findAll(); 
    }

    // Buscar 
    public Producto getById(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id); // Busca por ID
        return producto.orElse(null); 
    }

    // Crear 
    public Producto add(Producto producto) {
        return productoRepository.save(producto); // Guarda y retorna 
    }

    // Actualizar 
    public Producto update(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setIdProducto(id); // Aseguramos que se use el mismo ID
            return productoRepository.save(producto); // Guarda los cambios
        }
        return null; // No se encontró la persona
    }

    // Eliminar una por ID
    public Producto delete(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.deleteById(id); 
            return producto.get(); // Retorna la eliminada
        }
        return null; // No existe
    }
}