package com.example.retotecnico.mapper;


import com.example.retotecnico.dto.RegisterRequest;


import com.example.retotecnico.model.Usuario;


public class AuthMapper {


    public static RegisterRequest toResponse(Usuario usuario) {
        return new RegisterRequest(
                usuario.getUsername(),
                usuario.getRol().getNombre()
        );
    }
}
