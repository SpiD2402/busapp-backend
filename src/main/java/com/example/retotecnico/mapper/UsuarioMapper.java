package com.example.retotecnico.mapper;


import com.example.retotecnico.dto.UsuarioDTO;
import com.example.retotecnico.model.Usuario;

public class UsuarioMapper {


    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setPassword(usuario.getPassword());
        dto.setRol(RoleMapper.toDTO(usuario.getRol()));
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(RoleMapper.toEntity(dto.getRol()));
        return usuario;
    }
}
