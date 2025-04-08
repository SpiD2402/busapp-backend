package com.example.retotecnico.service;

import com.example.retotecnico.dto.AuthResponse;
import com.example.retotecnico.dto.LoginRequest;
import com.example.retotecnico.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    RegisterRequest register(RegisterRequest request);
}
