package com.cliente.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial_compra") // tabla historial compra
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historialcompra")
    private Integer idHistorialCompra;
    private String fechaCompra;
    private int montoTotal;
    @ManyToOne
@JoinColumn(name = "id_cliente")  // nombre igual que en la tabla cliente
private Cliente cliente;


}