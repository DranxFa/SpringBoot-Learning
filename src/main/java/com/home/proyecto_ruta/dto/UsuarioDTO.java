package com.home.proyecto_ruta.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Set;

public record UsuarioDTO(

        @NotBlank(message = "El usuario no puede estar vacio.")
        String usuario,

        @NotBlank(message = "La contraseña no puede estar vacio.")
        String password,
        Set<String> roles
) {
}
