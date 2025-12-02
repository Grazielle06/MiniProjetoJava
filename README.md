# Sistema de Gestão de Alunos – Spring Boot MVC

## 1. Introdução
Neste projeto, desenvolvemos um sistema web utilizando **Java com Spring Boot**, seguindo o padrão **MVC**.  
O objetivo foi construir um sistema de gestão de alunos com cadastro e listagem, usando formulários e persistência no banco de dados.

---

## 2. Estrutura do Projeto
A aplicação foi organizada em pacotes para manter uma estrutura limpa e fácil de entender.  
Os principais pacotes são:

- **model** – classes que representam os dados, ou seja, as entidades do banco.
- **controller** – classes que controlam as rotas e recebem as requisições do usuário.
- **repository** – interfaces responsáveis pela comunicação com o banco de dados, usando Spring Data JPA.
- **templates** – páginas HTML construídas com Thymeleaf.

---

## 3. Explicação das Camadas

### Model
Nesta camada definimos as entidades da aplicação.  
São classes que representam as tabelas do banco, onde cada atributo vira uma coluna.  
O Spring Boot cria essas tabelas automaticamente.

### Repository
Os repositórios usam **Spring Data JPA** para realizar a persistência.  
Essa camada oferece métodos prontos como `save`, `findAll`, entre outros, evitando a escrita manual de SQL.

### Controller
A camada Controller é responsável por receber as requisições do usuário.  
Ela chama os métodos do repositório e retorna a página adequada.  
Nela são definidas rotas como:
- `/alunos`
- `/cursos`
- `/alunos/novo`
- `/cursos/movo`

### Templates (Views com Thymeleaf)
As páginas HTML foram construídas com **Thymeleaf**, permitindo:
- Exibir dados dinâmicos
- Conectar campos dos formulários com atributos das entidades
- Trabalhar com validações e mensagens de erro

---

## 4. Funcionamento das Rotas

O Controller trabalha com caminhos base como `/alunos` e `/cursos`.  
Dentro dele, são definidas três rotas principais:

### 1) GET `/cursos`
Busca todos os registros através do repositório e retorna a view de listagem.

### 2) GET `/cursos/novo`
Exibe o formulário de cadastro.  
Nessa rota são enviados para a view:
- Um objeto vazio da entidade
- A lista de cursos carregada pelo repositório

Isso permite que o formulário monte corretamente o campo `<select>`.

### 3) POST `/cursos`
Recebe os dados enviados pelo formulário e os salva no banco via repositório.
OBS: O mesmo fluxo se aplica à entidade **alunos**, mas com a diferença de que o aluno está associado a um curso, exigindo acesso ao repositório de cursos.

---

## 5. Funcionamento dos Formulários
Os formulários utilizam **Thymeleaf**, que permite ligar os campos HTML diretamente aos atributos das entidades.  
Quando o usuário envia o formulário, os dados são automaticamente preenchidos em um objeto Java correspondente.

---

## 6. Persistência e Banco de Dados
A persistência foi implementada com **Spring Data JPA**, utilizando o banco **H2** em memória.  
Com isso, toda a comunicação com o banco é feita pelos repositórios, sem necessidade de escrever SQL manualmente.

---

## 7. A aplicação iniciará na porta **8081** (pelo log do Spring Boot).

---

## Vídeo de Apresentação

**Link do vídeo:** 
