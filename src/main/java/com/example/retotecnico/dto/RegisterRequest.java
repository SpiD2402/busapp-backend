package com.example.retotecnico.dto;

public class RegisterRequest {


    private String username;
    private String password;
    private String rol;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public RegisterRequest(String username, String nombre) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
