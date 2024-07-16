package com.aluracursos.ForoAluraHub.domain.usuario_perfil;

public record DatosListadoUsuario_Perfil(
        String nombreUsuario,
        String nombrePerfil
) {
    public DatosListadoUsuario_Perfil(Usuario_Perfil usuarioPerfil) {
        this(usuarioPerfil.getUsuario().getNombre(), usuarioPerfil.getPerfil().getNombre());
    }
}