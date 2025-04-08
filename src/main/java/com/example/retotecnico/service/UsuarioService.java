package com.example.retotecnico.service;

import com.example.retotecnico.dto.RegisterRequest;
import com.example.retotecnico.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO crearUsuario(RegisterRequest request);
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(Long id);
    void eliminarUsuario(Long id);
}
