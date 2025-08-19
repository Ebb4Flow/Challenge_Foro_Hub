package com.Challenge.Foro_Hub.usuario;

import com.Challenge.Foro_Hub.perfil.registroPerfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registroUsuario(
        @NotBlank String nombre,
        @NotBlank @Email String correoElectronico,
        @NotBlank String contrasena,
        @NotNull Long perfilId
){
}
