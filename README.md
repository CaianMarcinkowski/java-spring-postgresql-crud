# CRUD com Java Spring

Este é um projeto de CRUD (Create, Read, Update, Delete) implementado em Java com o framework Spring. O objetivo deste projeto é fornecer um exemplo simples e funcional de um sistema de gerenciamento de produtos usando tecnologias Java e Spring.

## Tecnologias Utilizadas

- **PostgreSQL**: Este projeto utiliza o banco de dados PostgreSQL para armazenar os dados dos produtos. Certifique-se de que o PostgreSQL esteja instalado e configurado corretamente antes de executar o aplicativo.

- **Spring Framework**: O aplicativo é desenvolvido usando o Spring Framework (3.1.0), incluindo módulos como Spring Web, Spring Data JPA e Flyway para gerenciamento de migração de banco de dados.

- **Java**: O código do aplicativo é escrito em Java, versão 20.

- **Maven**: O sistema de gerenciamento de dependências Maven é utilizado para gerenciar as bibliotecas e as configurações do projeto.

- **JPA (Java Persistence API)**: O JPA é utilizado para mapeamento objeto-relacional, facilitando a interação com o banco de dados.

- **Flyway**: O Flyway é utilizado para gerenciar as migrações de banco de dados, garantindo que o banco de dados esteja sempre atualizado com as últimas alterações de esquema.

- **Sistema de Autenticação com JWT**: Este projeto inclui um sistema de autenticação baseado em JWT (JSON Web Token) para garantir a segurança e a autenticação de usuários. O JWT é uma tecnologia amplamente utilizada para autenticação e autorização em aplicativos da web e fornece uma maneira segura de transmitir informações de autenticação entre o cliente e o servidor.

- **BCrypt**: O BCrypt é um algoritmo de criptografia usado para armazenar senhas com segurança. Ele torna difícil para os invasores descobrirem senhas por meio de ataques de força bruta e usa um processo de "salting" para aumentar a segurança, garantindo que senhas idênticas tenham hashes diferentes. Isso ajuda a proteger as credenciais dos usuários de forma eficaz.

## Estrutura do Banco de Dados

O projeto utiliza a seguinte estrutura de tabela no banco de dados PostgreSQL para armazenar informações sobre produtos e usuarios:

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

```sql
CREATE TABLE Users(
id SERIAL PRIMARY KEY NOT NULL,
login TEXT NOT NULL UNIQUE,
password TEXT NOT NULL,
role TEXT NOT NULL
);
```
Esta tabela possui os seguintes campos:

    id: Um identificador único para cada usuario (chave primária).

    login: O login do usuario, pode ser email, nome, nickname, etc...

    password: A senha do usuario.

    role: um campo para diferenciar usuarios como Admisnitradores e usuarios comuns.

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

O sistema de autenticação com JWT oferece os seguintes endpoints para gerenciar a autenticação e autorização de usuários:

- **POST /auth/login**: Permite que os usuários façam login no sistema e recebam um token JWT válido.

- **POST /auth/register**: Permite que os usuários se registrem no sistema, criando uma nova conta com informações de autenticação.

Certifique-se de seguir as instruções fornecidas na seção "Como Executar o Projeto" para configurar e usar o sistema de autenticação com JWT em seu ambiente local. Para exemplos de solicitações HTTP relacionadas à autenticação e ao uso de tokens JWT, consulte a seção "Exemplo de Uso".

## Exemplo de Uso

Para interagir com a API, você pode utilizar ferramentas como o Postman ou fazer requisições HTTP diretamente.

Para registrar um novo usuário no sistema, você precisa enviar um JSON com informações de registro, como nome de usuário, senha e outros detalhes relevantes.

```bash
POST http://localhost:8080/auth/register
Content-Type: application/json

{
"login": "novousuario",
"password": "senhadonovousuario",
"role": "ADMIN" ou "USER"
}
```

Para fazer login no sistema e obter um token JWT, você precisa enviar um JSON com as credenciais de login, como nome de usuário e senha.

```bash
POST http://localhost:8080/auth/login
Content-Type: application/json

{
"login": "novousuario",
"password": "senhadonovousuario"
}
```

Aqui está um exemplo de solicitação HTTP para criar um novo produto:

Obs.: Certifique-se de incluir o token JWT apropriado ("/auth/login") no cabeçalho da solicitação como "Authorization: Bearer {token}" para autenticar e acessar com sucesso este endpoint de criação de produtos.

```bash
POST http://localhost:8080/product
Content-Type: application/json

{
"name": "Produto de Exemplo",
"price": 19.99
"active": true
}
```

Lembre-se de que esses são exemplos genéricos e que os nomes dos campos e os detalhes específicos podem variar dependendo da implementação real em seu projeto. Certifique-se de seguir as convenções e os campos definidos em sua própria implementação de autenticação JWT.

Para obter a lista de produtos, você pode fazer uma solicitação GET para `http://localhost:8080/product`. No entanto, para acessar esta lista de produtos, é necessário fornecer um token JWT válido no cabeçalho da solicitação como "Authorization: Bearer {token}". Certifique-se de incluir o token JWT apropriado para autenticar e acessar com sucesso os recursos de produtos.

Lembre-se de que este é apenas um projeto de exemplo e pode ser expandido e personalizado de acordo com as necessidades do seu próprio aplicativo.
