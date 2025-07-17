package com.envios.models;

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
@Table(name = "estado_envio") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_EstadoEnvio")
    private Integer idEstadoEnvio;
    private String descripcionEnvio;
    private Integer orden;
    private Boolean finalizado;

    
}