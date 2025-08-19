package com.Challenge.Foro_Hub.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registroRespuesta(
        @NotBlank String mensaje,
        @NotNull Long autorId,
        @NotNull Long topicoId
) {
}
