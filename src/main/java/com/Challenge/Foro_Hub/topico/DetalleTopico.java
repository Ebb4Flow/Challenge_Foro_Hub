package com.Challenge.Foro_Hub.topico;

import java.time.LocalDateTime;

public record DetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
    public DetalleTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso());
    }
}