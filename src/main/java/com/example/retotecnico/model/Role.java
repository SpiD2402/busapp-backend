package com.example.retotecnico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    public Role() {
    }

    public Role(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
