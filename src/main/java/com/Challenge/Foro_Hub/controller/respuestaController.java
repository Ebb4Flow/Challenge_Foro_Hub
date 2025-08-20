package com.Challenge.Foro_Hub.controller;

import com.Challenge.Foro_Hub.domain.respuesta.DetalleRespuesta;
import com.Challenge.Foro_Hub.domain.respuesta.RegistroRespuesta;
import com.Challenge.Foro_Hub.domain.serivces.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    private final RespuestaService service;

    public RespuestaController(RespuestaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DetalleRespuesta> registrar(@RequestBody @Valid RegistroRespuesta datos) {
        var respuesta = service.registrar(datos);
        return ResponseEntity.ok(new DetalleRespuesta(respuesta));
    }
}