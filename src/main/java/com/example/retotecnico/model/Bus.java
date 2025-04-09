package com.example.retotecnico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_bus", nullable = false, unique = true)
    private String numeroBus;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "caracteristicas")
    private String caracteristicas;

    @Column(name = "fecha_creacion", updatable = false,nullable = false)
    private LocalDateTime fechaCreacion ;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

}
