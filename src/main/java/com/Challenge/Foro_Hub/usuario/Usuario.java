package com.Challenge.Foro_Hub.usuario;

import com.Challenge.Foro_Hub.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_electronico", unique = true, nullable = false)
    private String correoElectronico;

    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    public Usuario(registroUsuario datos, Perfil perfil) {
        this.id = null;
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = datos.contrasena();
        this.perfil = perfil;
    }
}