package com.example.retotecnico.mapper;

import com.example.retotecnico.dto.MarcaDTO;
import com.example.retotecnico.dto.RoleDTO;
import com.example.retotecnico.model.Marca;
import com.example.retotecnico.model.Role;

public class RoleMapper {

    public static RoleDTO toDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setNombre(role.getNombre());
        return dto;
    }

    public static Role toEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setNombre(dto.getNombre());
        return role;
    }

}
