package com.Challenge.Foro_Hub.domain.topico;

import com.Challenge.Foro_Hub.domain.respuesta.DetalleRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso,
        List<DetalleRespuesta> respuestas
) {
    public DetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso(),
                topico.getRespuestas().stream()
                        .map(DetalleRespuesta::new)
                        .toList()
        );
    }
}