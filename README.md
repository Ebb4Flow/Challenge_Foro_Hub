<body>
  <h1>📌 Challenge Foro Hub</h1>

  <p>
    Este proyecto corresponde al <strong>Challenge Foro Hub</strong> de <strong>Alura Latam</strong>, cuyo objetivo principal es desarrollar una <strong>API REST para un foro</strong> utilizando <strong>Java</strong> y <strong>Spring Boot</strong>.
  </p>

  <p>
    La API permite la gestión de <strong>usuarios</strong>, <strong>tópicos de discusión</strong> y <strong>respuestas</strong>, implementando autenticación mediante <strong>JWT</strong> y aplicando buenas prácticas de desarrollo con el <strong>Spring Framework</strong>.
  </p>

  <h2>🚀 Características principales</h2>
  <ul>
    <li>Registro y autenticación de usuarios con JWT.</li>
    <li>CRUD completo para Tópicos.</li>
    <li>CRUD para Usuarios y Respuestas.</li>
    <li>Validaciones y manejo de errores centralizado.</li>
    <li>Conexión con base de datos relacional (H2 o MySQL).</li>
    <li>Documentación de la API con Swagger/OpenAPI.</li>
  </ul>

  <h2>🛠️ Tecnologías utilizadas</h2>
  <ul>
    <li>Java 17+</li>
    <li>Spring Boot 3</li>
    <li>Spring Security</li>
    <li>JWT (JSON Web Tokens)</li>
    <li>Spring Data JPA / Hibernate</li>
    <li>Base de datos H2 (en memoria) o MySQL</li>
    <li>Maven</li>
    <li>Swagger UI</li>
  </ul>

  <h2>📂 Estructura del proyecto</h2>
  <pre>
Challenge_Foro_Hub/
│── src/main/java/com/Challenge/Foro_Hub/
│   ├── controller/    # Controladores REST
│   ├── dto/           # Objetos de transferencia de datos
│   ├── entity/        # Entidades JPA
│   ├── repository/    # Repositorios
│   ├── service/       # Lógica de negocio
│   └── infra/         # Seguridad, configuración JWT
│
│── src/main/resources/
│   ├── application.properties
│
│── clave.txt          # Contiene usuarios de prueba con sus credenciales
│
└── pom.xml
  </pre>

  <h2>⚙️ Configuración e instalación</h2>
  <ol>
    <li><strong>Clonar el repositorio:</strong></li>
  </ol>
  <pre>
git clone https://github.com/Ebb4Flow/Challenge_Foro_Hub.git
cd Challenge_Foro_Hub
  </pre>

  <ol start="2">
    <li><strong>Configurar el archivo <code>application.properties</code>:</strong></li>
  </ol>
  <p>Para H2 (default):</p>
  <pre>
spring.datasource.url=jdbc:h2:mem:forohub
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
  </pre>

  <p>Para MySQL:</p>
  <pre>
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=root
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
  </pre>

  <ol start="3">
    <li><strong>Ejecutar el proyecto:</strong></li>
  </ol>
  <pre>
mvn spring-boot:run
  </pre>

  <h2>📖 Endpoints principales</h2>
  <h3>🔑 Autenticación</h3>
  <ul>
    <li>POST /login → Retorna un JWT para autenticación.</li>
  </ul>

  <h3>👤 Usuarios</h3>
  <ul>
    <li>POST /usuarios → Crear usuario.</li>
    <li>GET /usuarios → Listar usuarios.</li>
  </ul>

  <h3>📝 Tópicos</h3>
  <ul>
    <li>POST /topicos → Crear un nuevo tópico.</li>
    <li>GET /topicos → Listar todos los tópicos.</li>
    <li>GET /topicos/{id} → Detalle de un tópico.</li>
    <li>PUT /topicos/{id} → Actualizar un tópico.</li>
    <li>DELETE /topicos/{id} → Eliminar un tópico.</li>
  </ul>

  <h3>💬 Respuestas</h3>
  <ul>
    <li>POST /respuestas → Crear respuesta.</li>
    <li>GET /respuestas/{id} → Detalle de una respuesta.</li>
  </ul>

  <h2>🔐 Seguridad</h2>
  <p>
    El proyecto implementa autenticación mediante <strong>JWT</strong>. Los usuarios deben autenticarse en <code>/login</code> y luego incluir el token en cada request:
  </p>
  <pre>
Authorization: Bearer &lt;tu_token&gt;
  </pre>

  <h2>📑 Documentación con Swagger</h2>
  <p>
    Una vez levantado el proyecto, la documentación de la API estará disponible en:
    <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>
  </p>

  <h2>⚠️ Notas importantes</h2>
  <ul>
    <li>El archivo <code>clave.txt</code> contiene usuarios de prueba con sus credenciales para testear la API.</li>
    <li>Para que el proyecto funcione correctamente, es necesario realizar <code>INSERT INTO</code> en las tablas de <strong>usuarios</strong>, <strong>roles</strong> u otras relacionadas, además de la tabla de tópicos.</li>
  </ul>

  <h2>📜 Licencia</h2>
  <p>
    Este proyecto se distribuye bajo la licencia <strong>MIT</strong>.
  </p>
</body>