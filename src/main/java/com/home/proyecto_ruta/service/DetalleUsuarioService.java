package com.home.proyecto_ruta.service;

import com.home.proyecto_ruta.entity.Usuario;
import com.home.proyecto_ruta.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleUsuarioService implements UserDetailsService {

    UsuarioRepository usuarioRepository;

    public DetalleUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos el usuario en SQL Server
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Convertimos nuestros roles (String) en objetos que Spring Security entienda (GrantedAuthority)
        List<SimpleGrantedAuthority> autoridades = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol))
                .collect(Collectors.toList());

        // Retornamos el usuario estándar de Spring Security
        return new User(usuario.getUsername(), usuario.getPassword(), autoridades);
    }
}
