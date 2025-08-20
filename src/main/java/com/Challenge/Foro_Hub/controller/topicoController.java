package com.Challenge.Foro_Hub.controller;

import com.Challenge.Foro_Hub.domain.serivces.TopicoService;
import com.Challenge.Foro_Hub.domain.topico.ActualizarTopico;
import com.Challenge.Foro_Hub.domain.topico.DetalleTopico;
import com.Challenge.Foro_Hub.domain.topico.RegistroTopico;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController{

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DetalleTopico> registrar(@RequestBody @Valid RegistroTopico datos) {
        var topico = service.registrar(datos);
        return ResponseEntity.ok(new DetalleTopico(topico));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetalleTopico>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTopico> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleTopico> actualizar(
            @PathVariable Long id,
            @RequestBody @Valid ActualizarTopico datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204, sin contenido
    }
}