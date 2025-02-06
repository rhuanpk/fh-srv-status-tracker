# Resumo do Projeto

Este projeto é um rastreador de status de vídeos, desenvolvido com Spring Boot. Ele permite criar, atualizar e buscar status de vídeos associados a um usuário específico. O projeto utiliza um banco de dados MySQL para armazenar os dados e está configurado para ser executado em um ambiente Docker.

# Workflow de CI/CD

Este projeto utiliza o GitHub Actions para automação do pipeline de CI/CD. O workflow realiza as seguintes etapas:

1 - Compilação e Testes: O código é compilado e os testes são executados utilizando o Maven.
2 - Análise de Qualidade de Código com SonarQube: O projeto é analisado automaticamente pelo SonarCloud.
3 - Criação e Envio da Imagem Docker: O código é empacotado em uma imagem Docker e enviada para o Docker Hub.
Para mais detalhes, consulte o arquivo .github/workflows/build.yml.

# SonarCloud

A análise de qualidade do código é realizada utilizando SonarCloud. O relatório de análise está disponível publicamente. Você pode visualizar os detalhes de qualidade, cobertura de testes e outros insights no seguinte link: https://sonarcloud.io/project/overview?id=brunocamposousa_fh-srv-status-tracker

# Documentação do VideoController

O `VideoController` é responsável por gerenciar as requisições relacionadas aos vídeos. Ele possui os seguintes endpoints:

## GET /videos/{userName}

Retorna uma lista de vídeos associados ao usuário especificado.

**Parâmetros:**
- `userName` (String): O nome do usuário para filtrar os vídeos.

**Exemplo de Requisição:**
```http
GET /videos/johndoe
```

**Exemplo de Resposta:**
```json
[
  {
    "id": 1,
    "userName": "johndoe",
    "videoId": "abc123",
    "status": "COMPLETED"
  },
  {
    "id": 2,
    "userName": "johndoe",
    "videoId": "def456",
    "status": "IN_PROGRESS"
  }
]
```

## POST /videos

Cria um novo status de vídeo.

**Corpo da Requisição:**
```json
{
  "userName": "johndoe",
  "videoId": "abc123",
  "status": "COMPLETED"
}
```

**Exemplo de Requisição:**
```http
POST /videos
Content-Type: application/json

{
  "userName": "johndoe",
  "videoId": "abc123",
  "status": "COMPLETED"
}
```

**Exemplo de Resposta:**
```http
HTTP/1.1 201 Created
```

## PUT /videos

Atualiza o status de um vídeo existente.

**Corpo da Requisição:**
```json
{
  "id": 1,
  "status": "COMPLETED"
}
```

**Exemplo de Requisição:**
```http
PUT /videos
Content-Type: application/json

{
  "id": 1,
  "status": "COMPLETED"
}
```

**Exemplo de Resposta:**
```http
HTTP/1.1 204 No Content
```

# Variáveis de Ambiente

As seguintes variáveis de ambiente são necessárias para configurar o banco de dados MySQL:

- `MYSQL_HOST`: Host do banco de dados MySQL.
- `MYSQL_PORT`: Porta do banco de dados MySQL.
- `MYSQL_DATABASE`: Nome do banco de dados.
- `MYSQL_USER`: Usuário do banco de dados.
- `MYSQL_PASSWORD`: Senha do usuário do banco de dados.
- `MYSQL_ROOT_PASSWORD`: Senha do usuário root do banco de dados.

# Como Rodar o Aplicativo

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd fh-srv-status-tracker
   ```

2. Configure as variáveis de ambiente no arquivo `.env`:
   ```bash
   cp .env.example .env
   # Edite o arquivo .env com as suas configurações
   ```

3. Execute o Docker Compose para iniciar os serviços:
   ```bash
   docker-compose up --build
   ```

4. A aplicação estará disponível em `http://localhost:8080`.

# Swagger

O projeto utiliza Swagger para documentar a API. Para acessar a documentação Swagger, navegue até `http://localhost:8080/swagger-ui.html` após iniciar a aplicação.