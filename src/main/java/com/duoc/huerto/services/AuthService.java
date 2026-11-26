package com.duoc.huerto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.duoc.huerto.model.entities.Usuarios;
import com.duoc.huerto.model.request.AuthResponse;
import com.duoc.huerto.model.request.LoginRequest;
import com.duoc.huerto.repositories.UsuariosRepository;
import com.duoc.huerto.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // devuelve false si el username ya existe
    public boolean registrar(LoginRequest request){
        if (usuariosRepository.existsByUsername(request.getUsername())) {
            return false;
        }
        Usuarios usuario = new Usuarios();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuariosRepository.save(usuario);
        return true;
    }

    // devuelve null si las credenciales no son validas
    public AuthResponse login(LoginRequest request){
        Usuarios usuario = usuariosRepository.findByUsername(request.getUsername()).orElse(null);
        if (usuario == null || !passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return null;
        }
        String token = jwtService.generarToken(usuario.getUsername());
        return new AuthResponse(token, "Bearer", jwtService.getExpiracionSegundos());
    }

}