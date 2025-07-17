package com.soporte.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket") // tabla direccion
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;
    
    @ManyToOne
    private TipoSoporte tipoSoporte;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacionTicket; 
    private LocalDate fechaCierreTicket; 
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}