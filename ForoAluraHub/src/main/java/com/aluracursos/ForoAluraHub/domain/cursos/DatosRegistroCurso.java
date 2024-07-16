package com.aluracursos.ForoAluraHub.domain.cursos;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record DatosRegistroCurso(

        @NotBlank
        String nombre,
        @Nullable
        String categoria
) {
}