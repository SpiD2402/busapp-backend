package com.example.retotecnico.controller;

import com.example.retotecnico.dto.RoleDTO;
import com.example.retotecnico.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> obtenerTodosLosRoles() {
        List<RoleDTO> roles = roleService.obtenerTodasLosRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> obtenerRolePorId(@PathVariable Long id) {
        RoleDTO role = roleService.obtenerRolePorId(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> crearRole(@RequestBody RoleDTO roleDTO) {
        RoleDTO nuevoRole = roleService.crearRole(roleDTO);
        return new ResponseEntity<>(nuevoRole, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> actualizarRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        RoleDTO roleActualizado = roleService.actualizarRole(id, roleDTO);
        return ResponseEntity.ok(roleActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRole(@PathVariable Long id) {
        roleService.eliminarRole(id);
        return ResponseEntity.noContent().build();
    }

}
