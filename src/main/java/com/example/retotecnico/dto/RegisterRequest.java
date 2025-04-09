package com.example.retotecnico.dto;

import lombok.Data;

@Data
public class RegisterRequest {


    private String username;
    private String password;
    private String rol;


    public RegisterRequest(String username, String nombre) {
    }

    public RegisterRequest() {

    }
}
