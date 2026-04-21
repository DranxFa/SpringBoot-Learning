package com.home.proyecto_ruta.dto;

import jakarta.validation.constraints.*;

public record MascotaDTO(

        @NotBlank(message = "El nombre no puede estar vacio.")
        @Size(min = 2, max = 50, message = "El nombre debe estar entre 2 y 50 caracteres.")
        String nombre,

        @NotBlank(message = "La especie no puede estar vacio.")
        String especie,

        @Min(value = 0, message = "La edad no puede ser menor que 0.")
        @Max(value = 30, message = "Dudo que la mascota viva mas de 30 años en este sistema.")
        Integer edad,
        Long duenoId
) {
}
