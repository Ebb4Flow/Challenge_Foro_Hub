package com.Challenge.Foro_Hub.controller;

import com.Challenge.Foro_Hub.domain.usuario.DatosAutenticacion;
import com.Challenge.Foro_Hub.domain.usuario.Usuario;
import com.Challenge.Foro_Hub.infra.security.TokenService;
import com.Challenge.Foro_Hub.infra.security.DatosTokenJTW;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.correoElectronico(), datos.contrasena());
        var autenticacion = manager.authenticate(authenticationToken);

        var tokenWTJ =  tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.
                ok(new DatosTokenJTW(tokenWTJ));
    }
}
