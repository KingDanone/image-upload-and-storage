# Image Upload and Storage

Este é um projeto de demonstração para um serviço de upload e armazenamento de imagens construído com Spring Boot.

## Descrição

O projeto fornece uma API RESTful para fazer upload de imagens e listar as imagens já enviadas. As informações das imagens são salvas em um banco de dados em memória (H2) e os arquivos são armazenados no sistema de arquivos local.

## Tecnologias Utilizadas

*   **Java 21**
*   **Spring Boot 3.4.0**
    *   **Spring Web:** Para a criação de endpoints RESTful.
    *   **Spring Data JPA:** Para a persistência de dados.
    *   **Spring Boot DevTools:** Para facilitar o desenvolvimento.
*   **H2 Database:** Banco de dados em memória.
*   **Dozer 7.0.0:** Para mapeamento de objetos entre DTOs e Entidades.
*   **Lombok:** Para reduzir código boilerplate.
*   **Maven:** Para gerenciamento de dependências e build do projeto.

## Funcionalidades

*   Upload de um arquivo de imagem.
*   Listagem de todas as imagens enviadas.
*   Persistência dos dados da imagem em um banco de dados H2.

## Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/image-upload-and-storage.git
    ```
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd image-upload-and-storage
    ```
3.  **Execute o projeto usando o Maven Wrapper:**
    ```bash
    ./mvnw spring-boot:run
    ```
    O servidor estará disponível em `http://localhost:8080`.

## Endpoints da API

A API expõe os seguintes endpoints:

### Upload de Imagem

*   **URL:** `/api/v1/upload`
*   **Método:** `POST`
*   **Tipo de Conteúdo:** `multipart/form-data`
*   **Parâmetros:**
    *   `file`: O arquivo de imagem a ser enviado.
*   **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": 1,
        "nome": "nome-da-imagem.jpg",
        "url": "http://localhost:8080/path/para/imagem.jpg"
    }
    ```
*   **Resposta de Erro (400 Bad Request):**
    ```
    "error saving image"
    ```

### Listar Imagens

*   **URL:** `/api/v1/upload`
*   **Método:** `GET`
*   **Resposta de Sucesso (200 OK):**
    ```json
    [
        {
            "id": 1,
            "nome": "nome-da-imagem.jpg",
            "url": "http://localhost:8080/path/para/imagem.jpg"
        },
        {
            "id": 2,
            "nome": "outra-imagem.png",
            "url": "http://localhost:8080/path/para/outra-imagem.png"
        }
    ]
    ```

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot:

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── KingDanone
│   │   │               ├── Startup.java
│   │   │               ├── business
│   │   │               │   ├── mapper
│   │   │               │   └── service
│   │   │               ├── data
│   │   │               │   ├── model
│   │   │               │   └── repository
│   │   │               └── presentation
│   │   │                   ├── controller
│   │   │                   └── dto
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
└── pom.xml
```
