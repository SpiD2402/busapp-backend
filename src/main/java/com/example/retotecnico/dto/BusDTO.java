package com.example.retotecnico.dto;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BusDTO {
    private Long id;

    private String numeroBus;

    private String placa;

    private String caracteristicas;

    private LocalDateTime fechaCreacion;

    private Boolean activo;

    private MarcaDTO marca;


}
