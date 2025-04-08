package com.example.retotecnico.controller;

import com.example.retotecnico.dto.MarcaDTO;
import com.example.retotecnico.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {


    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> listarTodasLasMarcas() {
        List<MarcaDTO> marcas = marcaService.obtenerTodasLasMarcas();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorId(@PathVariable Long id) {
        MarcaDTO marca = marcaService.obtenerMarcaPorId(id);
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<MarcaDTO> crearMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaDTO nuevaMarca = marcaService.crearMarca(marcaDTO);
        return new ResponseEntity<>(nuevaMarca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> actualizarMarca(@PathVariable Long id, @RequestBody MarcaDTO marcaDTO) {
        MarcaDTO marcaActualizada = marcaService.actualizarMarca(id, marcaDTO);
        return ResponseEntity.ok(marcaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Long id) {
        marcaService.eliminarMarca(id);
        return ResponseEntity.noContent().build();
    }

}
