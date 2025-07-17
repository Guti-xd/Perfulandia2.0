package com.vendedores.models;

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
@Table(name = "meta") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private Integer idMeta;
    private String descripcionMeta;
    private Integer Valor;
    private Boolean cumplido;
    private String fechaLimite;
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}
