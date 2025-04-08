package com.example.retotecnico.dto;

import com.example.retotecnico.model.Marca;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class BusDTO {
    private Long id;

    private String numeroBus;

    private String placa;

    private String caracteristicas;

    private LocalDateTime fechaCreacion;

    private Boolean activo;

    private MarcaDTO marca;

    public BusDTO() {
    }

    public BusDTO(Long id, String numeroBus, String placa, String caracteristicas, LocalDateTime fechaCreacion, Boolean activo, MarcaDTO marca) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.caracteristicas = caracteristicas;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }
}
