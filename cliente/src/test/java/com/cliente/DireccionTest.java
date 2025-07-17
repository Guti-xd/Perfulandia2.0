package com.cliente;

import com.cliente.models.Direccion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DireccionTest {


    @Test
    void testCrearDireccion() {   
        Direccion direccion = new Direccion();
        direccion.setIdDireccion(1);
        direccion.setCiudad("Santiago");
        direccion.setCalle("AV. Pajaritos 555");
        

        assertEquals(1, direccion.getIdDireccion());
        assertEquals("Santiago", direccion.getCiudad());
        assertEquals("AV. Pajaritos 555", direccion.getCalle());



    }
}