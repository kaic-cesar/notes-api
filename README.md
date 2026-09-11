# Notes API

API REST para gerenciamento de notas, desenvolvida com Java e Spring Boot.

O projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend e realizar o processo completo de deploy de uma aplicação Spring Boot, utilizando PostgreSQL, Flyway, Docker e serviços em nuvem.

## API em Produção

A API está publicada no Render:

https://notes-api-gzo1.onrender.com

> O serviço utiliza o plano gratuito do Render. Por isso, a primeira requisição após um período de inatividade pode levar alguns segundos para responder.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- PostgreSQL
- Flyway
- Maven
- Docker
- Neon
- Render

## Funcionalidades

A API permite:

- Criar uma nota
- Listar todas as notas
- Atualizar uma nota
- Excluir uma nota
- Validar os dados recebidos nas requisições
- Tratar exceções da aplicação
- Persistir os dados em PostgreSQL
- Versionar a estrutura do banco de dados com Flyway

## Endpoints

URL base:

```text
https://notes-api-gzo1.onrender.com/api/v1/notes
```

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/v1/notes` | Cria uma nova nota |
| GET | `/api/v1/notes` | Lista todas as notas |
| PUT | `/api/v1/notes/{id}` | Atualiza uma nota |
| DELETE | `/api/v1/notes/{id}` | Exclui uma nota |

## Exemplo de requisição

### Criar uma nota

```http
POST /api/v1/notes
Content-Type: application/json
```

```json
{
  "title": "Minha primeira nota",
  "content": "Aprendendo a realizar o deploy de uma aplicação Spring Boot."
}
```

## Arquitetura

```text
Cliente
   |
   | HTTPS
   v
Render
Spring Boot API
   |
   | JDBC
   v
Neon
PostgreSQL
```

A API Spring Boot é executada em um container Docker hospedado no Render.

O banco de dados PostgreSQL está hospedado no Neon e é acessado pela aplicação através de uma conexão JDBC.

As alterações na estrutura do banco de dados são controladas através de migrations utilizando Flyway.

## Variáveis de ambiente

As credenciais e informações de conexão com o banco de dados não são armazenadas diretamente no código.

A aplicação utiliza as seguintes variáveis de ambiente:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

No `application.yml`, essas variáveis são utilizadas da seguinte forma:

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

Dessa forma, diferentes configurações podem ser utilizadas em desenvolvimento e produção sem alterar o código-fonte.

## Executando localmente

### Requisitos

Para executar o projeto localmente é necessário possuir:

- Java 21
- PostgreSQL

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Configure as variáveis de ambiente:

```text
DB_URL=jdbc:postgresql://localhost:5432/notes_api
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```

### Windows

Execute:

```bash
.\mvnw.cmd spring-boot:run
```

### Linux/macOS

Execute:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080/api/v1/notes
```

## Migrations

O projeto utiliza Flyway para controlar o versionamento da estrutura do banco de dados.

As migrations ficam localizadas em:

```text
src/main/resources/db/migration
```

Exemplo:

```text
V1__create_notes_table.sql
```

Ao iniciar a aplicação, o Flyway verifica automaticamente quais migrations já foram executadas e aplica as migrations pendentes.

## Docker

A aplicação possui um `Dockerfile` utilizando multi-stage build.

O primeiro estágio utiliza Maven e Java 21 para gerar o arquivo `.jar` da aplicação.

O segundo estágio contém apenas o ambiente necessário para executar a aplicação.

Fluxo simplificado:

```text
Código-fonte
    |
    v
Maven
    |
    | mvn clean package
    v
Arquivo .jar
    |
    v
Java Runtime
    |
    v
Spring Boot
```

## Deploy

O fluxo de deploy da aplicação é:

```text
GitHub
   |
   v
Render
   |
   | Docker Build
   v
Spring Boot
   |
   | JDBC
   v
Neon PostgreSQL
```

Após as alterações serem integradas à branch `main`, o Render pode realizar um novo build e publicar a nova versão da aplicação.

## Estrutura do projeto

```text
src/main/java/com/kaiccesar/notes_api
├── exception
└── note
    ├── controller
    ├── dto
    ├── model
    ├── repository
    └── service
```

## Objetivo do projeto

Este projeto foi desenvolvido para praticar conceitos relacionados ao desenvolvimento e publicação de APIs REST, incluindo:

- Arquitetura em camadas
- DTOs
- Validação de requisições
- Tratamento global de exceções
- Spring Data JPA
- PostgreSQL
- Migrations com Flyway
- Variáveis de ambiente
- Containerização com Docker
- Deploy de aplicações Spring Boot
- Integração entre aplicação e banco de dados em nuvem

## Autor

Desenvolvido por Kaic Cesar como projeto de estudo de desenvolvimento backend com Java e Spring Boot.
