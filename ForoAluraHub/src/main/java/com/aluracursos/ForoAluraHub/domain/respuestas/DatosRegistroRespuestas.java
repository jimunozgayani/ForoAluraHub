package com.aluracursos.ForoAluraHub.domain.respuestas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuestas(
        @NotBlank
        String mensaje,
        @NotNull
        Long topico_id,
        @NotNull
        Long usuario_id
) {
}