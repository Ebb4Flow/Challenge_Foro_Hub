package com.Challenge.Foro_Hub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuesta(
        @NotBlank String mensaje,
        @NotNull Long autorId,
        @NotNull Long topicoId
) {
    public RegistroRespuesta(Respuesta respuesta) {
        this(
                respuesta.getMensaje(),
                respuesta.getAutor().getId(),
                respuesta.getTopico().getId()
        );
    }
}
