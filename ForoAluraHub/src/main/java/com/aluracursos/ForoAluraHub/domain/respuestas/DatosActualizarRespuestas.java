package com.aluracursos.ForoAluraHub.domain.respuestas;

import lombok.NonNull;

public record DatosActualizarRespuestas(
        @NonNull
        Long id,
        String mensaje,
        Boolean solucion
) {
}