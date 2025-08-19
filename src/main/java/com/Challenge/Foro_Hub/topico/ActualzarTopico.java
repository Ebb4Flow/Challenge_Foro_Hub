package com.Challenge.Foro_Hub.topico;

import jakarta.validation.constraints.NotNull;

public record ActualzarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String status,
        String curso
){
}
