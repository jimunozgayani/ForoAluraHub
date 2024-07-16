package com.aluracursos.ForoAluraHub.domain.perfiles;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(
        @NotBlank
        String nombre
) {
}