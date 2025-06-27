# 🐾 Dog API Tests

Este repositório contém uma suíte de testes automatizados criada para validar os principais endpoints da API https://dog.ceo/dog-api

Os testes foram desenvolvidos em Java utilizando RestAssured, JUnit 5 e os relatórios são gerados com Allure Report.

O processo de execução está automatizado via GitHub Actions com deploy contínuo do relatório.

---

## 🔧 Tecnologias Utilizadas

* Java 21
* Maven
* JUnit 5
* RestAssured
* JSON Schema
* Allure Report
* GitHub Actions

---

## ✅ O que está sendo validado

* Listagem de raças disponíveis
* Retorno de imagem para raça válida
* Retorno 404 para raça inválida
* Imagem aleatória de cachorro
* Validação de contrato no endpoint `/breeds/list/all` usando JSON Schema

---

### ▶️ Como Executar Localmente

#### 🔧 Pré-requisitos

Certifique-se de que as seguintes ferramentas estejam instaladas em sua máquina para executar os testes e gerar o relatório corretamente:

- Java 21 JDK: https://www.oracle.com/br/java/technologies/downloads/
- Apache Maven: https://maven.apache.org/download.cgi
- Allure Report: https://allurereport.org/docs/install-for-windows/

#### 🚀 Execução dos testes

```bash
# Clone o projeto
git clone https://github.com/thiagocastro01/dog-api-tests.git
cd dog-api-tests

# Execute os testes
mvn clean test

# Sirva o relatório localmente
allure serve target/allure-maven-plugin
```

---

## 🚀 Executar via GitHub Actions

Este projeto permite executar os testes diretamente pelo GitHub, sem a necessidade de rodar localmente ou realizar push de código.

### Como fazer:

1. Vá até a aba **Actions** no topo do repositório.
2. Selecione o workflow `Run all API Tests`.
3. Clique no botão **Run workflow**.
4. Mantenha marcada a branch **main**
5. Confirme com **Run workflow** novamente.

O GitHub irá executar os testes automaticamente no ambiente configurado, e o relatório Allure será gerado e publicado em:
🔗 [https://thiagocastro01.github.io/dog-api-tests/](https://thiagocastro01.github.io/dog-api-tests/)

> Essa opção é útil para revisores ou usuários externos validarem os testes sem precisar configurar nada em sua máquina.

## 📄 Relatório Online

Todos os testes são executados automaticamente a cada push na branch `master`.
O relatório Allure é gerado e publicado automaticamente via GitHub Pages:

🔗 [Clique aqui para acessar o relatório](https://thiagocastro01.github.io/dog-api-tests/)

---

## 🌱 Git Flow Utilizado

O fluxo de versionamento adotado é direto e baseado na branch `master`.

```bash
# Crie uma branch para sua feature ou fix
git checkout -b feature/nome-da-feature
# ou
git checkout -b fix/nome-do-ajuste

# Realize os commits
git add .
git commit -m "feature: descrição da alteração"

# Envie para o repositório remoto
git push origin nome-da-branch
```

1. Abra um Pull Request para a branch `master`
2. Aguarde os testes automatizados passarem
3. Realize o merge

---

## 📁 Estrutura do Projeto

```bash
dog-api-tests
├── .github/workflows/           # CI/CD com GitHub Actions
├── src
│   ├── main/java                # Lógica para suportar a execução dos casos de teste
│   └── test/java                # Casos de teste
│       └── resources/schemas    # JSON Schemas para contrato
├── pom.xml                      # Configurações do projeto
└── README.md
```

---

## 📘 Wiki

A **Wiki** centraliza toda a documentação técnica do projeto, incluindo:

* Arquitetura de testes
* Estratégia de automação
* Padrões de escrita e organização

📌 [Acesse a Wiki](https://github.com/thiagocastro01/dog-api-tests/wiki)

---
