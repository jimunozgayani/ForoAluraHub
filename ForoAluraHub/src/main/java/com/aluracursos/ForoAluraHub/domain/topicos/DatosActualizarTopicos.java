package com.aluracursos.ForoAluraHub.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicos(
        @NotNull
        Long id,
        String titulo,
        String mensaje
) {
}