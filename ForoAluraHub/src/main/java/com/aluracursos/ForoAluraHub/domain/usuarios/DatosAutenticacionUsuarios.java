package com.aluracursos.ForoAluraHub.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuarios(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contrasena)
{
}