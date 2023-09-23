# CRUD com Java Spring

Este é um projeto de CRUD (Create, Read, Update, Delete) implementado em Java com o framework Spring. O objetivo deste projeto é fornecer um exemplo simples e funcional de um sistema de gerenciamento de produtos usando tecnologias Java e Spring.

## Tecnologias Utilizadas

- **PostgreSQL**: Este projeto utiliza o banco de dados PostgreSQL para armazenar os dados dos produtos. Certifique-se de que o PostgreSQL esteja instalado e configurado corretamente antes de executar o aplicativo.

- **Spring Framework**: O aplicativo é desenvolvido usando o Spring Framework (3.1.0), incluindo módulos como Spring Web, Spring Data JPA e Flyway para gerenciamento de migração de banco de dados.

- **Java**: O código do aplicativo é escrito em Java, versão 20.

- **Maven**: O sistema de gerenciamento de dependências Maven é utilizado para gerenciar as bibliotecas e as configurações do projeto.

- **JPA (Java Persistence API)**: O JPA é utilizado para mapeamento objeto-relacional, facilitando a interação com o banco de dados.

- **Flyway**: O Flyway é utilizado para gerenciar as migrações de banco de dados, garantindo que o banco de dados esteja sempre atualizado com as últimas alterações de esquema.

## Estrutura do Banco de Dados

O projeto utiliza a seguinte estrutura de tabela no banco de dados PostgreSQL para armazenar informações sobre produtos:

```sql
CREATE TABLE product (
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    price INT NOT NULL,
    active boolean NOT NULL
);
```

Esta tabela possui os seguintes campos:

    id: Um identificador único para cada produto (chave primária).

    name: O nome do produto.

    price: O preço do produto.

    active: Um campo booleano que indica se o produto está ativo ou não.

## Como Executar o Projeto

1. Certifique-se de ter o PostgreSQL instalado e configurado corretamente. Você pode encontrar informações sobre como fazer isso na documentação oficial do PostgreSQL. (https://www.postgresql.org/download/)

2. Clone este repositório para o seu ambiente local. (https://github.com/CaianMarcinkowski/CRUD-PRODUCT.git)

3. Configure as propriedades do banco de dados no arquivo `application.properties`. Você deve definir o URL do banco de dados, nome de usuário e senha de acordo com a sua configuração local.

4. Abra o projeto em sua IDE favorita (por exemplo, IntelliJ IDEA ou Eclipse).

5. Execute o aplicativo Spring Boot. A API estará acessível em http://localhost:8080.

## Endpoints

O projeto oferece os seguintes endpoints para gerenciar os dados de produtos:

- **GET /product**: Recupera uma lista de todos os produtos cadastrados.

- **POST /product**: Registra um novo produto no sistema.

- **PUT /product**: Atualiza informações de um produto existente.

- **DELETE /product/?id={id}**: Desativa um produto com base no seu ID. Certifique-se de passar o ID correto como parâmetro na URL.

## Exemplo de Uso

Para interagir com a API, você pode utilizar ferramentas como o Postman ou fazer requisições HTTP diretamente.

Aqui está um exemplo de solicitação HTTP para criar um novo produto:

```bash
POST http://localhost:8080/product
Content-Type: application/json

{
"name": "Produto de Exemplo",
"price": 19.99
"active": true
}
```

Para obter a lista de produtos, você pode fazer uma solicitação GET para `http://localhost:8080/product`.

Lembre-se de que este é apenas um projeto de exemplo e pode ser expandido e personalizado de acordo com as necessidades do seu próprio aplicativo.
