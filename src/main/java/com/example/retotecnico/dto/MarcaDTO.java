package com.example.retotecnico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarcaDTO {

    private Long id;
    private String nombre;
    private List<BusDTO> buses;


}
