package com.example.retotecnico.dto;

import java.util.List;

public class MarcaDTO {

    private Long id;
    private String nombre;
    private List<BusDTO> buses;


    public MarcaDTO() {
    }

    public MarcaDTO(Long id, String nombre, List<BusDTO> buses) {
        this.id = id;
        this.nombre = nombre;
        this.buses = buses;
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

    public List<BusDTO> getBuses() {
        return buses;
    }

    public void setBuses(List<BusDTO> buses) {
        this.buses = buses;
    }
}
