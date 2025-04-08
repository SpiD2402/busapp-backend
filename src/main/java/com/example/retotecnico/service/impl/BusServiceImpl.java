package com.example.retotecnico.service.impl;

import com.example.retotecnico.dto.BusDTO;
import com.example.retotecnico.exception.ResourceNotFoundException;
import com.example.retotecnico.mapper.BusMapper;
import com.example.retotecnico.mapper.MarcaMapper;
import com.example.retotecnico.mapper.PagedResponse;
import com.example.retotecnico.model.Bus;
import com.example.retotecnico.repository.BusRepository;
import com.example.retotecnico.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class BusServiceImpl  implements BusService   {


    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public PagedResponse<BusDTO> listarPaginado(Pageable pageable) {
        Page<Bus> buses = busRepository.findAll(pageable);

        List<BusDTO> contenido = buses.getContent().stream()
                .map(BusMapper::toDTO)
                .toList();

        return new PagedResponse<>(
                contenido,
                buses.getNumber(),
                buses.getSize(),
                buses.getTotalElements(),
                buses.getTotalPages(),
                buses.isLast(),
                buses.isFirst(),
                buses.isEmpty()
        );
    }




    @Transactional(readOnly = true)
    @Override
    public BusDTO obtenerBusPorId(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus no encontrado con id: "+ id));
        return BusMapper.toDTO(bus);
    }
    @Transactional
    @Override
    public BusDTO crearBus(BusDTO busDTO) {
        Bus bus = BusMapper.toEntity(busDTO);
        bus.setFechaCreacion(LocalDateTime.now());
        bus.setActivo(true);
        Bus savedBus= busRepository.save(bus);
        return  BusMapper.toDTO(savedBus);
    }

    @Transactional(readOnly = true)
    @Override
    public BusDTO actualizarBus(Long id, BusDTO busDTO) {
            Bus existingBus = busRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bus no encontrado con id: "+id));
            existingBus.setNumeroBus(busDTO.getNumeroBus());
            existingBus.setPlaca(busDTO.getPlaca());
            existingBus.setCaracteristicas(busDTO.getCaracteristicas());
            existingBus.setActivo(busDTO.getActivo());
            existingBus.setMarca(MarcaMapper.toEntity(busDTO.getMarca()));
        return  BusMapper.toDTO(existingBus);
    }

    @Transactional(readOnly = true)
    @Override
    public void eliminarBus(Long id) {
        Bus existingBus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus no encontrado con id: "+id));
        existingBus.setActivo(false);
    }
}
