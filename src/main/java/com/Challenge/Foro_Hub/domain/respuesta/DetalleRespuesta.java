package com.Challenge.Foro_Hub.domain.respuesta;

import java.time.LocalDateTime;

public record DetalleRespuesta (
        Long id,
        String mensaje,
        String autor,
        LocalDateTime fechaCreacion
) {
    public DetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getAutor().getNombre(),
                respuesta.getFechaCreacion()
        );
    }
}