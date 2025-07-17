package com.vendedores.service;

import com.vendedores.models.Vendedor;
import com.vendedores.repository.VendedorRepository;
import org.junit.jupiter.api.BeforeEach;
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
public class VendedorServiceTest {

    @Mock
    private VendedorRepository vendedorRepository; // Mock del repositorio

    @InjectMocks
    private VendedorService vendedorService; // Servicio con el mock inyectado

    private Vendedor vendedor;

    @BeforeEach
    void setUp() {
        // Configuración común para todos los tests
        vendedor = new Vendedor();
        vendedor.setIdVendedor(1);
        vendedor.setNombre("Juan Pérez");
        vendedor.setGmail("juan@example.com");
        vendedor.setTelefono("123456789");
    }

    @Test
    void testGetAllVendedores() {
        // Configuración del mock
        Vendedor vendedor2 = new Vendedor();
        vendedor2.setIdVendedor(2);
        vendedor2.setNombre("María García");
        
        List<Vendedor> listaEsperada = Arrays.asList(vendedor, vendedor2);
        when(vendedorRepository.findAll()).thenReturn(listaEsperada);

        // Ejecución
        List<Vendedor> resultado = vendedorService.getAll();

        // Verificación
        assertEquals(2, resultado.size());
        assertEquals("Juan Pérez", resultado.get(0).getNombre());
        assertEquals("María García", resultado.get(1).getNombre());
        verify(vendedorRepository, times(1)).findAll();
    }

    @Test
    void testGetVendedorById_Existente() {
        // Configuración del mock
        when(vendedorRepository.findById(1)).thenReturn(Optional.of(vendedor));

        // Ejecución
        Vendedor resultado = vendedorService.getById(1);

        // Verificación
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdVendedor());
        assertEquals("Juan Pérez", resultado.getNombre());
        verify(vendedorRepository, times(1)).findById(1);
    }

    @Test
    void testGetVendedorById_NoExistente() {
        // Configuración del mock
        when(vendedorRepository.findById(99)).thenReturn(Optional.empty());

        // Ejecución
        Vendedor resultado = vendedorService.getById(99);

        // Verificación
        assertNull(resultado);
        verify(vendedorRepository, times(1)).findById(99);
    }

    @Test
    void testCrearVendedor() {
        // Configuración del mock
        when(vendedorRepository.save(any(Vendedor.class))).thenReturn(vendedor);

        // Ejecución
        Vendedor resultado = vendedorService.add(vendedor);

        // Verificación
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdVendedor());
        verify(vendedorRepository, times(1)).save(vendedor);
    }

    @Test
    void testActualizarVendedor_Existente() {
        // Configuración del mock
        Vendedor datosActualizados = new Vendedor();
        datosActualizados.setNombre("Juan Updated");
        datosActualizados.setGmail("nuevo@example.com");
        
        when(vendedorRepository.existsById(1)).thenReturn(true);
        when(vendedorRepository.save(any(Vendedor.class))).thenAnswer(invocation -> {
            Vendedor v = invocation.getArgument(0);
            v.setIdVendedor(1); // Simula el guardado
            return v;
        });

        // Ejecución
        Vendedor resultado = vendedorService.update(1, datosActualizados);

        // Verificación
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdVendedor());
        assertEquals("Juan Updated", resultado.getNombre());
        assertEquals("nuevo@example.com", resultado.getGmail());
        verify(vendedorRepository, times(1)).existsById(1);
        verify(vendedorRepository, times(1)).save(any(Vendedor.class));
    }

    @Test
    void testActualizarVendedor_NoExistente() {
        // Configuración del mock
        when(vendedorRepository.existsById(99)).thenReturn(false);

        // Ejecución
        Vendedor resultado = vendedorService.update(99, vendedor);

        // Verificación
        assertNull(resultado);
        verify(vendedorRepository, times(1)).existsById(99);
        verify(vendedorRepository, never()).save(any());
    }

    @Test
    void testEliminarVendedor_Existente() {
        // Configuración del mock
        when(vendedorRepository.findById(1)).thenReturn(Optional.of(vendedor));
        doNothing().when(vendedorRepository).deleteById(1);

        // Ejecución
        Vendedor resultado = vendedorService.delete(1);

        // Verificación
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdVendedor());
        verify(vendedorRepository, times(1)).findById(1);
        verify(vendedorRepository, times(1)).deleteById(1);
    }

    @Test
    void testEliminarVendedor_NoExistente() {
        // Configuración del mock
        when(vendedorRepository.findById(99)).thenReturn(Optional.empty());

        // Ejecución
        Vendedor resultado = vendedorService.delete(99);

        // Verificación
        assertNull(resultado);
        verify(vendedorRepository, times(1)).findById(99);
        verify(vendedorRepository, never()).deleteById(any());
    }
}