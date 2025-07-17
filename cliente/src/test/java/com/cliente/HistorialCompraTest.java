package com.cliente;


import com.cliente.models.HistorialCompra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HistorialCompraTest {


    @Test
    void testCrearDireccion() {   
        HistorialCompra historialCompra = new HistorialCompra();
        historialCompra.setIdHistorialCompra(1);
        historialCompra.setFechaCompra("07/05/2025");
        historialCompra.setCliente(null);
        historialCompra.setMontoTotal(3450);
        

        assertEquals(1, historialCompra.getIdHistorialCompra());
        assertEquals("07/05/2025", historialCompra.getFechaCompra());
        assertEquals(null, historialCompra.getCliente());
        assertEquals(3450, historialCompra.getMontoTotal());



    }
}