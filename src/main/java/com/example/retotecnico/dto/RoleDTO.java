package com.example.retotecnico.dto;

public class RoleDTO {

    private Long id;
    private String nombre;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
