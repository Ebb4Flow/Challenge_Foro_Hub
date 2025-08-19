package com.Challenge.Foro_Hub.respuesta;

import com.Challenge.Foro_Hub.topico.Topico;
import com.Challenge.Foro_Hub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private Boolean solucion = false;

    // Autor
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    // Tópico
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    public Respuesta(registroRespuesta datos, Usuario autor, Topico topico) {
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = autor;
        this.topico = topico;
    }
}