package com.example.retotecnico.service;

import com.example.retotecnico.dto.BusDTO;
import com.example.retotecnico.mapper.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BusService {
    PagedResponse<BusDTO> listarPaginado(Pageable pageable);
    BusDTO obtenerBusPorId(Long id);
    BusDTO crearBus(BusDTO busDTO);
    BusDTO actualizarBus(Long id, BusDTO busDTO);
    void eliminarBus(Long id);

}
