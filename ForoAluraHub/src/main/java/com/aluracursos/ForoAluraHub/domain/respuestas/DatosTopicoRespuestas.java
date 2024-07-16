package com.aluracursos.ForoAluraHub.domain.respuestas;
import java.time.LocalDateTime;

public record DatosTopicoRespuestas( String mensaje,
                                     LocalDateTime fecha,
                                     String nombre,
                                     Boolean solucion
) {
    public DatosTopicoRespuestas(Respuesta respuesta) {
        this(respuesta.getMensaje(), respuesta.getFecha(), respuesta.getUsuario().getNombre(), respuesta.getSolucion());
    }
}
