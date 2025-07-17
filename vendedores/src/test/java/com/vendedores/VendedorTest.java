package com.vendedores;

import com.vendedores.models.Vendedor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class VendedorTest {


    @Test
    void testCrearVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(1);
        vendedor.setNombre("Juan Marchant");
        vendedor.setGmail("juanmarchanttt@hotmail.com");
        vendedor.setTelefono("955258224");

        assertEquals(1, vendedor.getIdVendedor());
        assertEquals("Juan Marchant", vendedor.getNombre());
        assertEquals("juanmarchanttt@hotmail.com", vendedor.getGmail());
        assertEquals("955258224", vendedor.getTelefono());

    }
}