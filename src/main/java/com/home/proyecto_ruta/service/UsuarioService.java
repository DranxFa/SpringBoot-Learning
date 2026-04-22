package com.home.proyecto_ruta.service;

import com.home.proyecto_ruta.dto.UsuarioDTO;
import com.home.proyecto_ruta.entity.Usuario;
import com.home.proyecto_ruta.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public Usuario guardar(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.usuario());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.password()));
        usuario.setRoles(usuarioDTO.roles());

        return usuarioRepository.save(usuario);
    }
}
