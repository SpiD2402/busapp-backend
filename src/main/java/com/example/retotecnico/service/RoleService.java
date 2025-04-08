package com.example.retotecnico.service;


import com.example.retotecnico.dto.RoleDTO;


import java.util.List;

public interface RoleService {
    List<RoleDTO> obtenerTodasLosRoles();
    RoleDTO obtenerRolePorId(Long id);
    RoleDTO crearRole(RoleDTO roleDTO);
    RoleDTO actualizarRole(Long id, RoleDTO roleDTO);
    void eliminarRole(Long id);

}
