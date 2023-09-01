# Desafio-Full-Stack

**Author:** Lucas Barbosa Dourado - @lucasbdourado

Desefio Full Stack em Java EE 8. O objetivo do desafio é montar um sistema desde o Back-End utilizando tecnologias do Java EE. No meu desafio eu utilizei o Jax-RS para criação da API e AngularJS 1.8 para o Front-End.

## Tecnologias Utilizadas

- Java 11
- Java EE 8 (Jax-RS, JPA/Hibernate)
- AngularJS 1.8
- Bootstrap
- MySQL
- Apache Tomcat 9.0

## Estrutura do Projeto e Requisitos do Desafio

1. Back-End(API de Fornecedores) - Localizado na pasta Back-End. https://github.com/lucasbdourado/Desafio-Full-Stack/tree/master/backend/src/main/java/br/com/neomind/lucasbdourado/backend
2. Front-End(Consumo de API - SPA) - Localizado na pasta Back-End https://github.com/lucasbdourado/Desafio-Full-Stack/tree/master/backend/src/main/webapp
3. Relógio(Desafio de Lógica utilizando Java) - Localizado na pasta Relogio https://github.com/lucasbdourado/Desafio-Full-Stack/tree/master/relogio

Obs: Foi incluido o arquivo com os Endpoints do Postman com todas configurações incluidadas para realização do teste de endpoints e validações.

## Instruções para Testes:

Utilizar o Apache Tomcat 9.0 para configurar a execução da Application. Utilizar o arquivo de empacotamento gerado pelo maven "backend:war exploded" para realizar o deployment na configuração do servidor local do Apache Tomcat 9.0.

- Criar um Banco de Dados com nome: "neomind"

- URL: http://localhost:8080/backend_war_exploded/api/company/

Caso seja necessário utilizar o arquivo do postman disponibilizado para realizar os testes de endpoints.

## Preview

Aplicação Full Stack(Java EE + AngularJS):
<img src="https://github.com/lucasbdourado/Desafio-Full-Stack/assets/44330434/00d35dbc-9b77-4cf5-8398-c4d05445f973">

Relógio:

<img src="https://github.com/lucasbdourado/Desafio-Full-Stack/assets/44330434/e927138a-ec16-49bf-bbdc-b73ed772a2a1">



