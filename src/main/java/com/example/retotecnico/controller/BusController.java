package com.example.retotecnico.controller;

import com.example.retotecnico.dto.BusDTO;
import com.example.retotecnico.mapper.PagedResponse;
import com.example.retotecnico.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    //Paginacion con respuesta personalizada
    @GetMapping
    public ResponseEntity<PagedResponse<BusDTO>> listarPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        PagedResponse<BusDTO> buses = busService.listarPaginado(pageable);
        return ResponseEntity.ok(buses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> obtenerBusPorId(@PathVariable Long id) {
        return ResponseEntity.ok(busService.obtenerBusPorId(id));
    }


    @PostMapping
    public ResponseEntity<BusDTO> crearBus(@RequestBody BusDTO busDTO) {
        BusDTO nuevoBus = busService.crearBus(busDTO);
        return new ResponseEntity<>(nuevoBus, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BusDTO> actualizarBus(@PathVariable Long id, @RequestBody BusDTO busDTO) {
        return ResponseEntity.ok(busService.actualizarBus(id, busDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBus(@PathVariable Long id) {
        busService.eliminarBus(id);
        return ResponseEntity.noContent().build();
    }

}
