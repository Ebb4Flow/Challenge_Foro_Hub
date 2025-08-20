package com.Challenge.Foro_Hub.domain.serivces;

import com.Challenge.Foro_Hub.domain.respuesta.respuestaRepositorio;
import com.Challenge.Foro_Hub.domain.topico.topicoRepositorio;
import com.Challenge.Foro_Hub.domain.usuario.usuarioRepositorio;
import com.Challenge.Foro_Hub.domain.respuesta.RegistroRespuesta;
import com.Challenge.Foro_Hub.domain.respuesta.Respuesta;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    private final respuestaRepositorio respuestaRepository;
    private final usuarioRepositorio usuarioRepository;
    private final topicoRepositorio topicoRepository;

    public RespuestaService(respuestaRepositorio respuestaRepository,
                            usuarioRepositorio usuarioRepository,
                            topicoRepositorio topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }

    @Transactional
    public Respuesta registrar(RegistroRespuesta datos) {
        var usuario = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        if ("CERRADO".equalsIgnoreCase(topico.getStatus())) {
            throw new RuntimeException("No se pueden agregar respuestas a un tópico cerrado");
        }

        var respuesta = new Respuesta(
                datos.mensaje(),
                usuario,
                topico
        );

        return respuestaRepository.save(respuesta);
    }
}
