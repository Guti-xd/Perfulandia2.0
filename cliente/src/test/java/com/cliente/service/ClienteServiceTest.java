package com.cliente.service;

import com.cliente.models.Cliente;
import com.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository; // Mock del repositorio

    @InjectMocks
    private ClienteService clienteService; // Servicio a testear (con el mock inyectado)

    // Test para getAll()
    @Test
    public void testGetAll_RetornaListaClientes() {
        // Configurar mock
        Cliente cliente1 = new Cliente(1, "Diego Roman", "21234637-k", "978829942", "Admin");
        Cliente cliente2 = new Cliente(2, "Ana López", "12345678-9", "912345678", "User");
        List<Cliente> clientesMock = Arrays.asList(cliente1, cliente2);
        
        when(clienteRepository.findAll()).thenReturn(clientesMock);

        // Ejecutar método
        List<Cliente> resultado = clienteService.getAll();

        // Verificar
        assertEquals(2, resultado.size());
        assertEquals("Diego Roman", resultado.get(0).getNombreCompleto());
        verify(clienteRepository, times(1)).findAll();
    }

    // Test para getById() - Cliente existe
    @Test
    public void testGetById_ClienteExiste() {
        Cliente clienteMock = new Cliente(1, "Diego Roman", "21234637-k", "978829942", "Admin");
        when(clienteRepository.findById(1)).thenReturn(Optional.of(clienteMock));

        Cliente resultado = clienteService.getById(1);

        assertEquals("Diego Roman", resultado.getNombreCompleto());
        verify(clienteRepository, times(1)).findById(1);
    }

    // Test para getById() - Cliente no existe
    @Test
    public void testGetById_ClienteNoExiste() {
        when(clienteRepository.findById(99)).thenReturn(Optional.empty());

        Cliente resultado = clienteService.getById(99);

        assertNull(resultado); // Verifica que retorna null
    }

    // Test para add()
    @Test
    public void testAdd_GuardaClienteCorrectamente() {
        Cliente nuevoCliente = new Cliente(null, "Nuevo Cliente", "11111111-1", "999999999", "User");
        Cliente clienteGuardado = new Cliente(3, "Nuevo Cliente", "11111111-1", "999999999", "User");
        
        when(clienteRepository.save(nuevoCliente)).thenReturn(clienteGuardado);

        Cliente resultado = clienteService.add(nuevoCliente);

        assertEquals(3, resultado.getIdCliente());
        verify(clienteRepository, times(1)).save(nuevoCliente);
    }

    // Test para update() - Cliente existe
    @Test
    public void testUpdate_ClienteExiste() {
        Cliente clienteActualizado = new Cliente(1, "Diego Actualizado", "21234637-k", "987654321", "Admin");
        
        when(clienteRepository.existsById(1)).thenReturn(true);
        when(clienteRepository.save(clienteActualizado)).thenReturn(clienteActualizado);

        Cliente resultado = clienteService.update(1, clienteActualizado);

        assertEquals("Diego Actualizado", resultado.getNombreCompleto());
        verify(clienteRepository, times(1)).existsById(1);
        verify(clienteRepository, times(1)).save(clienteActualizado);
    }

    // Test para update() - Cliente no existe
    @Test
    public void testUpdate_ClienteNoExiste() {
        Cliente clienteActualizado = new Cliente(99, "No Existe", "00000000-0", "000000000", "User");
        
        when(clienteRepository.existsById(99)).thenReturn(false);

        Cliente resultado = clienteService.update(99, clienteActualizado);

        assertNull(resultado); // Verifica que retorna null
    }

    // Test para delete() - Cliente existe
    @Test
    public void testDelete_ClienteExiste() {
        Cliente clienteAEliminar = new Cliente(1, "Diego Roman", "21234637-k", "978829942", "Admin");
        
        when(clienteRepository.findById(1)).thenReturn(Optional.of(clienteAEliminar));

        Cliente resultado = clienteService.delete(1);

        assertEquals("Diego Roman", resultado.getNombreCompleto());
        verify(clienteRepository, times(1)).deleteById(1);
    }

    // Test para delete() - Cliente no existe
    @Test
    public void testDelete_ClienteNoExiste() {
        when(clienteRepository.findById(99)).thenReturn(Optional.empty());

        Cliente resultado = clienteService.delete(99);

        assertNull(resultado); // Verifica que retorna null
    }
}