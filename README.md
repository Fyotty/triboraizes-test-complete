# Tribo Raizes Teste Técnico

Este projeto é uma aplicação REST simples desenvolvida com Java 17 e Spring Boot para gerenciar informações sobre produtos, atendendo aos requisitos do teste técnico.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Security + JWT** para autenticação
- **Spring Data JPA** para persistência
- **PostgreSQL** como banco de dados principal
- **Flyway** para migrações de banco de dados
- **Lombok** para redução de boilerplate
- **SpringDoc OpenAPI (Swagger)** para documentação da API
- **JUnit 5 + Mockito** para testes

## Padrões de Projeto Aplicados

- **DAO (Data Access Object)**: Utilizado para abstrair a persistência de dados.
- **Factory**: Utilizado para a criação de instâncias do DAO.
- **DTO (Data Transfer Object)**: Utilizado para representar os dados nas requisições e respostas da API.

## Como Executar

### Pré-requisitos

- Java 17
- Maven
- PostgreSQL rodando localmente (ou via Docker)

### Configuração do Banco de Dados

Crie um banco de dados chamado `triboraizes_db` no PostgreSQL. As configurações padrão no `application.properties` são:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/triboraizes_db
spring.datasource.username=triboraizes_user
spring.datasource.password=triboraizes_password
```

### Executando a Aplicação

1. Clone o repositório.
2. Navegue até a pasta do projeto.
3. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```

### Documentação Swagger

Após iniciar a aplicação, a documentação Swagger estará disponível em:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Autenticação

A maioria das rotas é protegida por JWT. Para acessar:

1. Realize o login no endpoint `/api/auth/login` com as credenciais:
   - **Username**: admin
   - **Password**: admin123
2. Utilize o token retornado no header `Authorization` como `Bearer <token>`.

## Testes

Para executar os testes unitários e de integração:
```bash
mvn test
```
