## Lojinha API Automação
Esse é um repositório que contém automação de alguns testes de API REST de um software chamado Lojinha. Os sub-tópicos descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias utilizadas

-Java JDK
(https://www.oracle.com/br/java/technologies/downloads/#jdk19-windows)

-JUnit
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1

-RestAssured
https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.3.0

-Maven
https://maven.apache.org/

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$0,01 e R$7.000,00.

## Notas Gerais

-Sempre utilizamos a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de teste.
-Armazenamos os dados que são enviados para a API através do uso de classes POJO
-Criamos dados iniciais através do uso de classe Data Factory, para facilitar a criação e controle dos dados.
-Nesse projeto fazemos o uso do JUnit 5, que nos dá possibilidade de usar a anotação DisplayName para dar descrições em português para os testes.