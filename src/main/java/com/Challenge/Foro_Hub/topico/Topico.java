package com.Challenge.Foro_Hub.topico;

import com.Challenge.Foro_Hub.respuesta.Respuesta;
import com.Challenge.Foro_Hub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String status;

    // Relación: un usuario puede crear muchos tópicos, pero un tópico tiene un solo autor
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    // Simplificamos el curso como un String
    private String curso;

    // Relación: un tópico puede tener muchas respuestas
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    public Topico(registroTopico datos, Usuario autor) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "ABIERTO";
        this.autor = autor;
        this.curso = datos.curso();
    }

    public void actualizar(ActualzarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null) {
            this.status = datos.status();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}