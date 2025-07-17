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
@Table(name = "KPls") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KPls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reportes")
    private Integer idreportes;
    private Integer totalVentas;
    private Integer ventaPromedio;
    private String fechaInicio;
    private String fechaFinal;
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}