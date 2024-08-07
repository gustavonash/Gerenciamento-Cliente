# Micro Serviço de Gerenciamento de Clientes

## Descrição

Este projeto é um micro serviço responsável por todas as operações relacionadas aos clientes de uma empresa, incluindo a criação, leitura, atualização e exclusão de registros de clientes (CRUD). Além das operações básicas, o serviço oferece funcionalidades adicionais para filtrar clientes por estado, representante e pesquisa de nome.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.5.4**
- **Spring Data JPA**
- **H2 Database (para desenvolvimento e testes)**
- **Lombok**
- **Postman (para testes das APIs)**

## Funcionalidades

1. **CRUD de Clientes**
   - Criação, leitura, atualização e exclusão de registros de clientes.

2. **Funcionalidades Extras**
   - Filtragem de clientes por estado.
   - Filtragem de clientes por representante.
   - Pesquisa de clientes pelo nome (usando LIKE).

## Configuração do Projeto

### Pré-requisitos

- JDK 11 ou superior
- Maven
- Postman (para testes)

### Configuração do Banco de Dados

O projeto utiliza o H2 Database para desenvolvimento e testes. A configuração do banco de dados está definida no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
