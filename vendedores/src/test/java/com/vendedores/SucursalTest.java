package com.vendedores;

import com.vendedores.models.Sucursal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SucursalTest {


    @Test
    void testCrearSucursal() {
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(1);
        sucursal.setNombreSucursal("Sucursal Maipú");
        sucursal.setDireccion("San Borja 922");

        assertEquals(1, sucursal.getIdSucursal());
        assertEquals("Sucursal Maipú", sucursal.getNombreSucursal());
        assertEquals("San Borja 922", sucursal.getDireccion());

    }
}