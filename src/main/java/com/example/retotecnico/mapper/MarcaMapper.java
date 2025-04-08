package com.example.retotecnico.mapper;

import com.example.retotecnico.dto.MarcaDTO;
import com.example.retotecnico.model.Marca;

public class MarcaMapper {

    public static MarcaDTO toDTO(Marca marca) {
        MarcaDTO dto = new MarcaDTO();
        dto.setId(marca.getId());
        dto.setNombre(marca.getNombre());
        return dto;
    }

    public static Marca toEntity(MarcaDTO dto) {
        Marca marca = new Marca();
        marca.setId(dto.getId());
        marca.setNombre(dto.getNombre());
        return marca;
    }
}
