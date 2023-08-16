# Compass-Scholarship

O projeto consiste no registro de estudantes, organizadores (Coordenador, Scrum Master e Instutores), squads em uma turma.

O projeto foi desenvolvido utilizando Java 17, SpringBoot 3.0.9, Maven e MySql 8.

As seguintes dependências foram usadas:
- Spring web
- MySQL driver
- Spring Data JDBC
- Spring Data JPA
- Spring Validation
- Spring DevTools
- Spring Starter test

## A Aplicação foi densenvolvida seguindo as seguintes regras:

1. Description:

- Your goal in this technical challenge is to develop a RESTful API using the Spring Boot framework in Java 17 and SpringBoot 3.0.9 , which is capable of handling the basic operations of the four HTTP verbs: GET, POST, PUT and DELETE. In addition, you must implement data persistence in a database, with two possible options: MySQL or MongoDB. The domain of the application is free to choose, but the objective must be to register information for the classes of the Compass Scholarship Program.

- It should have at least the registration of organizers (Coordinators, instructors and Scrum Master), the registration of students, registration of classes, registration of squads, etc.

2. Mandatory:

- document your progress and choices, use the README for this and also to teach how to run your project.
- Import the postman's collection, pay attention to the body of the requests.
- Project Metadata Group next pattern your name and last name (name.lastname).
- Minimum 3 branches (use Pull Request) .
- Minimum 5 commits.

3. Business Rules:

- Class must have a minimum of 15 * students and a maximum of 30 *.
- The class must have 3 statuses: waiting, started, finished.
- You can only register new students in the status: waiting.
- There must be an end to changing the status to finished.
- Each squad should have a maximum of 5 * students and be as balanced as possible.
- To start the class you need 1 * coordinator, 1 * scrum master and 3 * instructors.
- Numbers followed by * : Possible items that can be configured.

4. Requirements:

- Version your API
- You need an end point or SQL script that populates the database with 3 coordinators, 3 scrum masters, 3 instructors and exactly 14 students.
- Domain Modeling: Model the application domain according to the theme, identifying the relevant entities, attributes and relationships. Make sure you create a cohesive and meaningful structure to represent your domain.
- Implementing HTTP verbs: Implement endpoints for each of the four HTTP verbs (GET, POST, PUT, and DELETE) that allow manipulation of domain entities.
- Database Persistence: Implement the persistence layer using a relational MySQL database or a non-relational MongoDB database, depending on your preference. Use the appropriate Spring Boot tools and resources to perform the integration with the selected database. The database must be named "db_scholarship", the login and password "root".
- Well Defined Resources: Clearly define which resources will be made available by your API and how they should be accessed. Consider using good API design practices, such as using the plural for resource names and adopting a consistent naming pattern.
- End point that shows the class and its members
- Unit Tests: Develop unit tests to verify the correct functioning of important classes and methods in your application. Be sure to cover the most relevant use cases and ensure the integrity of your code. Use a code analysis tool and ensure that it is covered by at least 30% of tests ideal more than 70%.
- Integration Tests with Mock MVC: Create integration tests using the Mock MVC framework to simulate HTTP requests and verify that API endpoints are responding correctly. Be sure to test for success cases as well as error scenarios such as invalid requests or resources not found.

## Para o desenvolvimento de tal o seguinte pensamento foi utilizado: 
1. Seria necessária a criação de uma turma que tivesse estudantes, organizadores e squads. Por sua vez os alunos que estivessem nas turmas também estariam nas squads criadas.
2. As seguintes relações entre as entidades foram criadas para atingir o propósito do projeto:
- 1 estudante pode estar em apenas 1 turma.
- 1 estudante pode estar em apenas 1 squad.
- 1 turma pode ter vários estudantes.
- 1 turma pode ter vários squads.
- 1 turma pode ter apenas 1 coordenador.
- 1 turma pode ter apenas 1 scrum master.
- 1 turma pode ter 3 instrutores.
- 1 coordenador pode estar em apenas 1 turma.
- 1 scrum master pode estar em apenas 1 turma.
- 1 instrutor pode estar apenas em 1 turma.
3. Para a aplicação começar a funcionar mais rapidamente um script sql foi criado dentro da pasta "resources" com os inserts de 14 estudantes, 1 coordenador, 1 scrum master e 3 instrutores", caso contrário seria necessário povoar o banco de dados manualmente.

## Como rodar a aplicação

Dando sequência irei monstrar como utilizar a aplicação:

1. É necessário fazer o import da collection do postman presente na pasta resources/docs.
2. Cirar um estudante usando a seguinte requisição presente na collection do Postman -> "Post student in classroom and squad". Isso crirá o 15º estudante no squad e na turma que é necessário para inciar uma turma.

- ```json
  {
    "student_name" : "Cléber"
  }
  ```

- obs: Note que no path é nessário que o id de squad esteja no 3. -> localhost:8080/api/v1/classroom/1/squad/3/students

3. Em seguida é necessário alterar o status da turma para "started" usando a requisição -> "Update Classroom". Isso fará que a classe seja iniciada com seus 15 estudantes, 1 coordenador, 1 scrum master e 3 instrutores.

- ```json
  {
    "classroom_name" : "Turma A",
    "status" : "started"
  }
  ```
  
4. Na sequência deve-se alterar o status da turma para "finished" usando novamente a requisição -> "Update Classroom". Isso irá finalizar a turma.

- ```json
  {
    "classroom_name" : "Turma A",
    "status" : "finished"
  }
  ```
5. Em seguida deve-se pedir para listar todos os membros dentro de uma turma usando a requisição -> "Get Classroom full info". Com isso será possível ver todos os membros cadastrados nessa turma.
  
6. Por fim a turma e todos os seus membros podem ser excluídos usando a requisição -> "Delete Classroom". Isso irá apagar todos os dados presentes no projeto.

Essa é a sequência básica do projeto.

## Como rodar a aplicação com todas suas funcionalidades

A fim de que seja possível testar a aplicação novamente com todas suas funcionalidades e tendo que mexer pouco no Postman eu deixei a configuração do banco de dados no application.properties como "create-drop". Note que para persistencia desses dados após encerrar a aplicação a configuração correta seria "update".

Outro detalhe para rodar novamente a aplicação e testar todos os enpoints é que dentro de application.properties deve-se comentar o seguintes comando:
```
spring.sql.init.mode=always
```
Tendo feito isso é possível testar todos os endpoints.

Esta é a sequencia para tal:

1. Criar uma turma usando a seguinte requisição -> "Post Classroom".

- ```json
  {
    "classroom_name" : "Turma B",
    "status" : "waiting"
  }
  ```
2. Criar um squad dentro de uma turma usando a requisiçãoo -> "Post Squad in classroom". 

- ```json
  {
    "squad_name" : "Kanbanbans"
  }
  ```
3. Criar 5 estudantes dentro de um squad e dentro de uma turma usando a seguinte requisição -> "Post student in classroom and squad". É necessário fazer 5 requisições deste tipo e então voltar ao passo 2 pra que outra squad seja criada. Caso mais do que 5 estudantes tentem ser cirado dentro de uma única squad um erro será apresentado. São necessárias 3 squads para que o número de 15 alunos sejam criados em uma turma.

- ```json
  {
    "student_name" : "Cléber"
  }
  ```
- Lembrar de na url mudar o id de squad para 1 ao inserir o primeiro aluno: localhost:8080/api/v1/classroom/1/squad/1/students

4. Criar um coordenador dentro de uma turma usando a requisição -> "Post Coordinator in classroom".

- ```json
  {
    "coordinator_name" : "Maykon"
  }
  ```
5. Criar um scrum master dentro de uma turma usando a requisição -> "Post ScrumMaster in classroom".

- ```json
  {
    "scrumMaster_name" : "Josue"
  }
  ```
6. Criar 3 instrutores dentro de uma turma usando a requisição -> "Post Instrucotr in classroom".

- ```json
  {
    "instructor_name" : "Clóvis"
  }
  ```
7. Tendo todos os organizadores e estudantes devidamente cadastrados é possível alterar o status da turma para "started" em -> "Update Classroom".

- ```json
  {
    "classroom_name" : "Turma A",
    "status" : "started"
  }
  ```
8. Em seguinda alterar para "finished" em -> "Update Classroom".

- ```json
  {
    "classroom_name" : "Turma A",
    "status" : "finished"
  }
  ```
9. Agora já é possível listar novamente todos os membros da turma em -> "Get Classroom full info".
  
10. Novamente é possóvel deletar a turma usando -> "Delete Classroom".

## Testes

Para a parte de testes foram utilizados o Junit5 e o Mockito.

Todos os testes contendo uma cobertura de 37% foram feitos tanto em testes unitário quanto de integração e estao presentes em test>java>jorge.mombach.school>controller e >service.

## Considerações finais
O projeto foi pensado de modo que não seja possível fazer o registro de um estudante, coordenador, scrum master ou instrutores sem que exista uma turma criada. Difere um pouco da petição incial, porém foi o método que encontrei para chegar no endpoint final que apresenta todos os membros dentro de uma turma.
