package com.example.retotecnico.service.impl;

import com.example.retotecnico.dto.MarcaDTO;
import com.example.retotecnico.exception.ResourceNotFoundException;
import com.example.retotecnico.mapper.MarcaMapper;
import com.example.retotecnico.model.Marca;
import com.example.retotecnico.repository.MarcaRepository;
import com.example.retotecnico.service.MarcaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl  implements MarcaService   {

    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MarcaDTO> obtenerTodasLasMarcas() {
        return marcaRepository.findAll().stream()
                .map(MarcaMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public MarcaDTO obtenerMarcaPorId(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca mo encontrada con id: "+id));

        return  MarcaMapper.toDTO(marca);
    }

    @Transactional
    @Override
    public MarcaDTO crearMarca(MarcaDTO marcaDTO) {
        Marca marca  = MarcaMapper.toEntity(marcaDTO);
        Marca marcaSaved = marcaRepository.save(marca);
        return  MarcaMapper.toDTO(marcaSaved);
    }

    @Transactional
    @Override
    public MarcaDTO actualizarMarca(Long id, MarcaDTO marcaDTO) {
        Marca existingMarca =  marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Marca no encontrada con el id: "+id));
        existingMarca.setNombre(marcaDTO.getNombre());
        return MarcaMapper.toDTO(existingMarca);
    }

    @Transactional
    @Override
    public void eliminarMarca(Long id) {
        Marca existingMarca =  marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Marca no encontrada con el id: "+id));
        marcaRepository.delete(existingMarca);
    }
}
