package com.reportes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario_critico") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioCritico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventarioC")
    private Integer idinventarioC;
    private String nombreProducto;
    private Integer sotckActual;
    private Integer stockMinimo;
    private String proveedor;
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}