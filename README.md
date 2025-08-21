# Bootcamp Java - Projeto POO  

Este projeto foi desenvolvido como desafio no **curso de Java da [Digital Innovation One (DIO)](https://www.dio.me/)**, com o objetivo de aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** e boas práticas de desenvolvimento em Java.  

O sistema simula um **Bootcamp** com **Cursos, Mentorias e Devs**, permitindo interações por meio de um **menu no terminal**.  

---

## Tecnologias utilizadas
- **Java 17+**  
- **Paradigma de Programação Orientada a Objetos (POO)**  
  - Abstração  
  - Encapsulamento  
  - Herança  
  - Polimorfismo  
- **Spring Boot** (para execução mais prática)  
- **Maven** ou **Gradle**  

---

##  Funcionalidades
- Criar cursos e mentorias  
- Listar conteúdos disponíveis no Bootcamp  
- Cadastrar devs  
- Inscrever devs em bootcamps  
- Devs podem progredir nos conteúdos  
- Calcular o XP total dos devs  
- Menu interativo no terminal para executar as ações  

---

## Exemplo de Menu no Terminal
```text
=== MENU BOOTCAMP ===
1 - Adicionar Curso
2 - Adicionar Mentoria
3 - Listar Conteúdos do Bootcamp
4 - Cadastrar Dev
5 - Inscrever Dev no Bootcamp
6 - Dev Progredir
7 - Mostrar Status de um Dev
0 - Sair
```

---

## Como executar

Usando Maven
```bash
mvn spring-boot:run
```

Ou gerar o .jar
```bash
mvn clean package
java -jar target/bootcamp-dio-0.0.1-SNAPSHOT.jar
```

Usando Gradle
```bash
./gradlew bootRun   # Linux/Mac
gradlew bootRun     # Windows
```

## Conceitos aplicados

 - Abstração: classe Conteudo como base para cursos e mentorias.

 - Encapsulamento: atributos privados com getters e setters.

 - Herança: Curso e Mentoria herdam de Conteudo.

 - Polimorfismo: cálculo de XP diferente em Curso e Mentoria.
