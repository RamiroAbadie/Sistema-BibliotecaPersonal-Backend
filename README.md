# 📚 Sistema-BibliotecaPersonal-Backend

Backend para el sistema de gestión de una **biblioteca personal y familiar**.
Permite administrar libros, autores, editoriales, ubicaciones y géneros de forma sencilla, pensado para uso doméstico en red local.

---

## 🚀 Tecnologías principales

- **Java 21**
- **Spring Boot 3**
- **MySQL**

## ⚙️ Configuración básica

1. **Clonar el repositorio**

2. **Configura application-example.properties de la siguietne forma:**
⚠️Renombra el archivo y borrar "-example" del nombre (**asi queda ignorado en el gitignore y no comprometes tu contraseña**) (si es que vas a usar git)⚠️
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_personal <--La URL de tu BD
spring.datasource.username=[tu_usuario]
spring.datasource.password=[tu_password]
spring.jpa.hibernate.ddl-auto=update
```
4. **Crear una BD en MySQL con las siguientes caracteristicas:**
<img width="2465" height="1612" alt="DiagramaMySQL(ultima version)" src="https://github.com/user-attachments/assets/9bb62c98-738d-43e5-aa3e-452dfd9420d7" />

5. **Correr el backend desde tu IDE favorito**

6. **Listo 🫡**

## 🗄️ Endpoints principales
/api/libros : CRUD de libros

/api/autores : CRUD de autores

/api/editoriales : CRUD de editoriales

/api/ubicaciones : Consultas de ubicaciones

/api/generos : CRUD de géneros

/api/paises : CRUD de países

## ✨ Autor
Desarrollado por Ramiro Abadie
Para uso personal y familiar.

## 🗝️ Licencia
Este proyecto es de uso personal y no tiene fines comerciales.
Puedes adaptarlo o mejorarlo para tu propia biblioteca. 🫡
