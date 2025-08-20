package com.Challenge.Foro_Hub.domain.serivces;

import com.Challenge.Foro_Hub.domain.topico.topicoRepositorio;
import com.Challenge.Foro_Hub.domain.usuario.usuarioRepositorio;
import com.Challenge.Foro_Hub.domain.topico.ActualizarTopico;
import com.Challenge.Foro_Hub.domain.topico.DetalleTopico;
import com.Challenge.Foro_Hub.domain.topico.Topico;
import com.Challenge.Foro_Hub.domain.topico.RegistroTopico;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private final topicoRepositorio topicoRepository;
    private final usuarioRepositorio usuarioRepository;

    public TopicoService(topicoRepositorio topicoRepository, usuarioRepositorio usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Topico registrar(RegistroTopico datos) {
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("Ya existe un tópico con ese título y mensaje");
        }

        var autor = usuarioRepository.getReferenceById(datos.autorId());

        var topico = new Topico(datos, autor);

        return topicoRepository.save(topico);
    }

    public List<DetalleTopico> listar() {
        return topicoRepository.findAll()
                .stream()
                .map(DetalleTopico::new)
                .collect(Collectors.toList());
    }

    public DetalleTopico obtenerPorId(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado con id: " + id));

        return new DetalleTopico(topico);
    }

    @Transactional
    public DetalleTopico actualizar(Long id, ActualizarTopico datos) {
        var optional = topicoRepository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Tópico no encontrado con id: " + id);
        }

        var topico = optional.get();

        // Validación de duplicado (mismo título + mensaje con distinto id)
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())
                && (!topico.getTitulo().equals(datos.titulo()) || !topico.getMensaje().equals(datos.mensaje()))) {
            throw new RuntimeException("Ya existe un tópico con ese título y mensaje");
        }

        // Actualizar datos
        topico.actualizar(datos);

        // Persistir cambios
        var actualizado = topicoRepository.save(topico);

        return new DetalleTopico(actualizado);
    }

    @Transactional
    public void eliminar(Long id) {
        var optional = topicoRepository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Tópico no encontrado con id: " + id);
        }

        // Si existe, eliminar
        topicoRepository.deleteById(id);
    }
}