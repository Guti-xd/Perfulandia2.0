package com.autenticacion.service;

import com.autenticacion.models.Usuario;
import com.autenticacion.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // Buscar
    public Usuario getById(Integer id) {
        Optional<Usuario> cliente = usuarioRepository.findById(id); 
        return cliente.orElse(null); 
    }

    // Crear
    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario); 
    }

    // Actualizar 
    public Usuario update(Integer id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setIdUsuario(id); 
            return usuarioRepository.save(usuario); 
        }
        return null; 
    }

    // Eliminar
    public Usuario delete(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id); // Elimina 
            return usuario.get(); 
        }
        return null; 
    }
}

