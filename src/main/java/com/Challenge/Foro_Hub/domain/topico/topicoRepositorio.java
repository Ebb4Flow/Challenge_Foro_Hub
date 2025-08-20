package com.Challenge.Foro_Hub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface topicoRepositorio extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}