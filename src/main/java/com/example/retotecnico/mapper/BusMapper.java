package com.example.retotecnico.mapper;

import com.example.retotecnico.dto.BusDTO;
import com.example.retotecnico.model.Bus;

public class BusMapper {

    public static BusDTO toDTO(Bus bus) {
        if (bus == null) return null;

        BusDTO dto = new BusDTO();
        dto.setId(bus.getId());
        dto.setNumeroBus(bus.getNumeroBus());
        dto.setPlaca(bus.getPlaca());
        dto.setCaracteristicas(bus.getCaracteristicas());
        dto.setFechaCreacion(bus.getFechaCreacion());
        dto.setActivo(bus.getActivo());
        dto.setMarca(MarcaMapper.toDTO(bus.getMarca())); // <-- convierte Marca a MarcaDTO

        return dto;
    }

    public static Bus toEntity(BusDTO dto) {
        if (dto == null) return null;

        Bus bus = new Bus();
        bus.setId(dto.getId());
        bus.setNumeroBus(dto.getNumeroBus());
        bus.setPlaca(dto.getPlaca());
        bus.setCaracteristicas(dto.getCaracteristicas());
        bus.setFechaCreacion(dto.getFechaCreacion());
        bus.setActivo(dto.getActivo());
        bus.setMarca(MarcaMapper.toEntity(dto.getMarca()));
        return bus;
    }

}
