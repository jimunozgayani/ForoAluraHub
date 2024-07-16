package com.aluracursos.ForoAluraHub.domain.usuario_perfil;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario_Perfil(
        @NotNull
        Long usuario_id,
        @NotNull
        Long perfil_id
) {
}