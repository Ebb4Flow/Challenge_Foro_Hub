package com.Challenge.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record ActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String status,
        @NotBlank String curso
){
}
