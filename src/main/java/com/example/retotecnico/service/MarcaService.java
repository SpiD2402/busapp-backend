package com.example.retotecnico.service;

import com.example.retotecnico.dto.MarcaDTO;

import java.util.List;

public interface MarcaService {

    List<MarcaDTO> obtenerTodasLasMarcas();
    MarcaDTO obtenerMarcaPorId(Long id);
    MarcaDTO crearMarca(MarcaDTO marcaDTO);
    MarcaDTO actualizarMarca(Long id, MarcaDTO marcaDTO);
    void eliminarMarca(Long id);


}
