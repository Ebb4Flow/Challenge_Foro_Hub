CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    perfil_id BIGINT NOT NULL,
    CONSTRAINT fk_usuario_perfil FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);