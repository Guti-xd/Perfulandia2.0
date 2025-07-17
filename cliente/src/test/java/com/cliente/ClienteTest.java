package com.cliente;
import com.cliente.models.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ClienteTest {


    @Test
    void testCrearCliente() {   
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombreCompleto("Diego Roman");
        cliente.setRut("21234637-k");
        cliente.setTelefono("978829942");
        cliente.setTipoCliente("Admin");

        assertEquals(1, cliente.getIdCliente());
        assertEquals("Diego Roman", cliente.getNombreCompleto());
        assertEquals("21234637-k", cliente.getRut());
        assertEquals("978829942", cliente.getTelefono());
        assertEquals("Admin", cliente.getTipoCliente());


    }
}