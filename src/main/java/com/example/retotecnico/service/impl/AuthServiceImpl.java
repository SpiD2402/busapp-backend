package com.example.retotecnico.service.impl;

import com.example.retotecnico.dto.AuthResponse;
import com.example.retotecnico.dto.LoginRequest;
import com.example.retotecnico.dto.RegisterRequest;
import com.example.retotecnico.model.Role;
import com.example.retotecnico.model.Usuario;
import com.example.retotecnico.repository.RoleRepository;
import com.example.retotecnico.repository.UsuarioRepository;
import com.example.retotecnico.security.JwtService;
import com.example.retotecnico.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService  {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(
            UsuarioRepository usuarioRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @Override
    public AuthResponse login(LoginRequest request) {
        UserDetails userDetails;

        try {
            userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("El usuario no existe.");
        }

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            String token = jwtService.generateToken(userDetails);
            Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            return new AuthResponse(token, usuario.getUsername(), usuario.getRol().getNombre());

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credenciales incorrectas. Por favor, verifica tu contraseña.");
        } catch (DisabledException e) {
            throw new DisabledException("La cuenta está deshabilitada. Por favor, contacta al administrador.");
        }
    }

    @Override
    public RegisterRequest register(RegisterRequest request) {
        Role role = roleRepository.findByNombre(request.getRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(role);

        usuarioRepository.save(usuario);
        RegisterRequest response = new RegisterRequest();
        response.setUsername(usuario.getUsername());
        response.setPassword(usuario.getPassword());
        response.setRol(role.getNombre());

        return response;
    }

}
