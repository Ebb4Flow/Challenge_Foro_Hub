CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso VARCHAR(100) NOT NULL,
    CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);