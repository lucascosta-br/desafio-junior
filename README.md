# desafio-junior
Desafio da vaga de Analista Programador Júnior

## 🚀 Tecnologias e Ferramentas Utilizadas

- Java 21
- Spring Boot 3
- Spring Web (API REST)
- Spring Data JPA (Persistência)
- PostgreSQL (Banco de Dados Relacional)
- Lombok (Redução de boilerplate)
- Bean Validation (Validação dos dados)
- SLF4J (Logs na aplicação)

---

## ⚙️ Como Executar o Projeto

### 🏦 Configurando o Banco de Dados

Antes de executar a aplicação, é necessário que você tenha uma instância do PostgreSQL instalada e em execução localmente.

- Crie um banco de dados chamado:

```
escola_pequenas_criancas
```

- Garanta que as credenciais de acesso (`username` e `password`) estejam configuradas corretamente no arquivo:

```
src/main/resources/application.yml
```

Exemplo de configuração:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/escola_pequenas_criancas
    username: postgres
    password: admin123
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true
    hibernate:
      ddl-auto: update
```

---

### ▶️ Executando o Projeto

1. Certifique-se de que o banco de dados esteja ativo.
2. Clone o repositório para sua máquina.
3. Na raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

ou, caso utilize uma IDE (IntelliJ, VS Code, Eclipse):

- Execute a classe principal:

```java
com.github.lucascostabr.desafio_junior.DesafioJuniorApplication
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🛠️ Endpoints Disponíveis

| Método | Endpoint                                  | Descrição                          |
|--------|-------------------------------------------|-------------------------------------|
| POST   | `/api/alunos`                            | Cadastrar novo aluno                |
| GET    | `/api/alunos`                            | Listar todos os alunos              |
| GET    | `/api/alunos/{id}`                       | Consultar aluno por ID              |
| PUT    | `/api/alunos/{id}`                       | Atualizar dados do aluno            |
| DELETE | `/api/alunos/{id}`                       | Remover aluno                       |
| GET    | `/api/alunos/turmas?turma=nomeTurma`          | Listar alunos por turma             |

---

## 🧑‍💻 Autor

Desenvolvido por **Lucas Costa**  
[GitHub](https://github.com/lucascosta-br) • [LinkedIn](https://www.linkedin.com/in/lucascosta-br)

---
