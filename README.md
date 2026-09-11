# Notes API

API REST desenvolvida com Java e Spring Boot para gerenciamento de notas.

O projeto foi criado com o objetivo de praticar conceitos fundamentais do desenvolvimento backend, como criação de APIs REST, persistência de dados, validação de requisições, tratamento de exceções e versionamento do banco de dados.

O projeto está em desenvolvimento e novas funcionalidades serão adicionadas conforme a evolução dos estudos.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- PostgreSQL
- Flyway
- Maven
- Lombok

## Funcionalidades

Atualmente, a API permite:

- Criar notas
- Listar notas
- Atualizar notas
- Excluir notas
- Validar os dados recebidos nas requisições
- Tratar exceções da aplicação
- Persistir os dados em PostgreSQL
- Gerenciar alterações no banco de dados com Flyway

## Endpoints

URL base para execução local:

```text
http://localhost:8080/api/v1/notes
```

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/v1/notes` | Cria uma nova nota |
| GET | `/api/v1/notes` | Lista todas as notas |
| PUT | `/api/v1/notes/{id}` | Atualiza uma nota |
| DELETE | `/api/v1/notes/{id}` | Exclui uma nota |

## Exemplos

### Criar uma nota

```http
POST /api/v1/notes
Content-Type: application/json
```

Body:

```json
{
  "title": "Estudar Spring Boot",
  "content": "Revisar conceitos de APIs REST e persistência com JPA."
}
```

### Listar notas

```http
GET /api/v1/notes
```

## Estrutura do projeto

O projeto utiliza uma arquitetura em camadas para separar as responsabilidades da aplicação:

```text
src/main/java/com/kaiccesar/notes_api
│
├── note
│   ├── controller
│   ├── dto
│   ├── model
│   ├── repository
│   └── service
│
└── exception
```

### Controller

Responsável por receber as requisições HTTP e retornar as respostas da API.

### Service

Responsável pelas regras e operações da aplicação.

### Repository

Responsável pelo acesso e persistência dos dados utilizando Spring Data JPA.

### DTO

Utilizado para definir os dados recebidos e retornados pela API, evitando a exposição direta das entidades de persistência.

### Model

Representa as entidades persistidas no banco de dados.

### Exception

Contém as exceções customizadas e o tratamento global de erros da aplicação.

## Banco de dados

A aplicação utiliza PostgreSQL como banco de dados relacional.

As configurações de conexão são fornecidas através de variáveis de ambiente:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Exemplo:

```text
DB_URL=jdbc:postgresql://localhost:5432/notes_db
DB_USERNAME=postgres
DB_PASSWORD=sua_senha
```

As credenciais do banco de dados não devem ser armazenadas diretamente no repositório.

## Migrations

O projeto utiliza Flyway para controlar o versionamento da estrutura do banco de dados.

As migrations estão localizadas em:

```text
src/main/resources/db/migration
```

A migration inicial é responsável pela criação da tabela de notas.

O Flyway verifica e executa automaticamente as migrations pendentes durante a inicialização da aplicação.

## Executando o projeto

### Pré-requisitos

Para executar a aplicação localmente é necessário ter instalado:

- Java 21
- PostgreSQL

### 1. Clone o repositório

```bash
git clone https://github.com/kaic-cesar/notes-api.git
```

Entre no diretório:

```bash
cd notes-api
```

### 2. Configure o PostgreSQL

Crie um banco de dados local para a aplicação.

Exemplo:

```text
notes_db
```

Configure as variáveis de ambiente:

```text
DB_URL=jdbc:postgresql://localhost:5432/notes_db
DB_USERNAME=postgres
DB_PASSWORD=sua_senha
```

### 3. Execute a aplicação

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Validação

Os dados recebidos pela API são validados utilizando Bean Validation.

Por exemplo, título e conteúdo são campos obrigatórios para a criação de uma nota.

Requisições inválidas retornam o status:

```text
400 Bad Request
```

## Tratamento de exceções

A aplicação possui tratamento global de exceções para padronizar as respostas de erro.

Entre os cenários tratados estão:

```text
400 Bad Request
404 Not Found
```

Por exemplo, operações realizadas com um ID inexistente retornam `404 Not Found`.

## Próximas evoluções

O projeto continuará sendo evoluído conforme novos conceitos forem estudados.

Algumas melhorias planejadas incluem:

- Busca de nota por ID
- Testes unitários
- Testes de integração
- Documentação da API com OpenAPI/Swagger
- Paginação
- Melhorias na padronização das respostas de erro

## Autor

Desenvolvido por Kaic Cesar como projeto de estudo.
