package com.Challenge.Foro_Hub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autorId,
        @NotBlank String curso
) {
}
