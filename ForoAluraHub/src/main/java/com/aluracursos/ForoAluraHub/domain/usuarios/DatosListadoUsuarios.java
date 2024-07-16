package com.aluracursos.ForoAluraHub.domain.usuarios;

public record DatosListadoUsuarios(
        Long id,
        String nombre
) {
    public DatosListadoUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}