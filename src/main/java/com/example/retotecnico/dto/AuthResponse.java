package com.example.retotecnico.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private String token;
    private String username;
    private String rol;


    public AuthResponse(String token, String username, String nombre) {
    }
}
