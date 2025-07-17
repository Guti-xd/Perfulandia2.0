package com.vendedores;

import com.vendedores.models.Meta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MetaTest {


    @Test
    void testCrearSucursal() {
        Meta meta = new Meta();
        meta.setIdMeta(1);
        meta.setDescripcionMeta("Venta");
        meta.setValor(3000);
        meta.setCumplido(true);
        meta.setFechaLimite("10/06/2025");

        assertEquals(1, meta.getIdMeta());
        assertEquals("Venta", meta.getDescripcionMeta());
        assertEquals(3000, meta.getValor());
        assertEquals(true, meta.getCumplido());
        assertEquals("10/06/2025", meta.getFechaLimite());

    }
}