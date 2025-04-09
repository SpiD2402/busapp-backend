package com.example.retotecnico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses;



}
