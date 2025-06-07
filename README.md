
# 🎬 DevMovie

Bem-vindo à **DevMovie**, uma API REST desenvolvida em **Java com Spring Boot** que permite aos usuários criar listas personalizadas de filmes, buscar por gênero diretamente da **TMDb API** e salvar seus filmes favoritos ou para assistir depois. 😎

## 🚀 Tecnologias Usadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring security
- JWT (com a biblioteca java-jwt, sem OAuth2)
- Hibernate Validator
- RestTemplate
- MySQL
- Lombok
- Swagger (OpenAPI)
- Maven

## 🧱 Estrutura de Pastas

```
src/main/java/com/domain/devmovie/
├── config/                  # Configurações gerais
├── controllers/             # Controllers REST
├── dto/                     # Data Transfer Objects
├── entities/                # Entidades JPA
├── entities/enums/          # Enumerações (ex: gêneros)
├── exceptions/              # Exceções personalizadas
├── mapper/                  # Conversores entre DTOs e entidades
├── repository/              # Repositórios JPA
├── service/                 # Lógica de negócio
└── DevMovieApplication.java # Classe principal
```

## 📂 Endpoints Principais

### 🎥 Filmes da TMDb por Gênero
```http
GET /api/filmes?genero=Terror
```
Retorna filmes diretamente da API TMDb filtrados por gênero.

### 📃 Criar uma Lista de Filmes
```http
POST /api/movie-lists/{userId}
Body:
{
  "name": "Terror Anos 80"
}
```

### ➕ Adicionar Filme à Lista
```http
POST /api/movie-lists/{listId}/add-movie
Body:
{
  "movieId": "12345",
  "title": "A Nightmare on Elm Street",
  "posterUrl": "https://image.tmdb.org/t/p/..."
}
```

### ❤️ Favoritar para Assistir Depois
```http
POST /api/users/{userId}/favorites
Body:
{
  "movieId": "12345",
  "title": "A Nightmare on Elm Street",
  "posterUrl": "https://image.tmdb.org/t/p/..."
}
```

## 🧪 DTOs

- `RequestMovieListDto`
- `RequestMovieListItemDto`
- `ResponseMovieListDto`
- `ResponseMovieListItemDto`
- `RequestUserMovieDto`
- `ResponseUserMovieDto`
- `FilmeDTO`

## 🔁 Mappers

- `MovieListMapper`
- `UserMovieMapper`
- `GeneroMapper`

## ⚠️ Exceções Personalizadas

- `UserNotFoundException`
- `MovieListNotFoundException`
- `MovieListItemNotFoundException`
- `UserMovieAlreadyExistsException`

## 📌 Enum: Gêneros da TMDb

Enum `TmdbMovieGenre` mapeia os IDs da TMDb para descrições em português (ex: `TERROR(27, "Terror")`).

## 🔧 application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/devmovie
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 🐘 Banco de Dados

- MySQL com tabelas criadas automaticamente pelo JPA.
- Tabelas principais: `tb_user`, `tb_movie_list`, `tb_movie_list_item`, `tb_user_movie`

## 📘 Swagger

Acesse `http://localhost:8080/swagger-ui.html` para explorar a API.

## ✨ Observações Finais

- O projeto está preparado para múltiplos usuários, cada um com suas listas e favoritos.
- Filmes são identificados pelo `title` e `movieId` retornados pela TMDb.
- Está pronto para ser acoplado a um frontend ou aplicativo.

