package com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Menu {
  private static final Scanner scanner = new Scanner(System.in);
  private static final Bootcamp bootcamp = new Bootcamp();
  private static final Set<Dev> devs = bootcamp.getDevsInscritos();

  public boolean showMenu() {
    bootcamp.setNome("Bootcamp Java Developer");
    bootcamp.setDescricao("Aprenda Java com POO, Collections e Spring");
    int opcao;
    do {
      System.out.println("\n=== MENU BOOTCAMP ===");
      System.out.println("1 - Adicionar Curso");
      System.out.println("2 - Adicionar Mentoria");
      System.out.println("3 - Listar Conteúdos do Bootcamp");
      System.out.println("4 - Cadastrar Dev");
      System.out.println("5 - Inscrever Dev no Bootcamp");
      System.out.println("6 - Dev Progredir");
      System.out.println("7 - Mostrar Status de um Dev");
      System.out.println("0 - Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1 -> adicionarCurso();
        case 2 -> adicionarMentoria();
        case 3 -> listarConteudos();
        case 4 -> cadastrarDev();
        case 5 -> inscreverDev();
        case 6 -> devProgredir();
        case 7 -> mostrarStatusDev();
        case 0 -> System.out.println("Encerrando...");
        default -> System.out.println("Opção inválida!");
      }
    } while (opcao != 0);
    return false;
  }

  private static void adicionarCurso() {
    Curso curso = new Curso();
    System.out.print("Título do curso: ");
    curso.setTitulo(scanner.nextLine());
    System.out.print("Descrição: ");
    curso.setDescricao(scanner.nextLine());
    System.out.print("Carga horária: ");
    curso.setCargaHoraria(scanner.nextInt());
    scanner.nextLine();

    bootcamp.getConteudos().add(curso);
    System.out.println("Curso adicionado com sucesso!");
  }

  private static void adicionarMentoria() {
    Mentoria mentoria = new Mentoria();
    System.out.print("Título da mentoria: ");
    mentoria.setTitulo(scanner.nextLine());
    System.out.print("Descrição: ");
    mentoria.setDescricao(scanner.nextLine());
    mentoria.setData(LocalDate.now());

    bootcamp.getConteudos().add(mentoria);
    System.out.println("Mentoria adicionada com sucesso!");
  }

  private static void listarConteudos() {
    System.out.println("\n--- Conteúdos do Bootcamp ---");
    bootcamp.getConteudos().forEach(c ->
        System.out.println(c.getTitulo() + " - " + c.getDescricao())
    );
  }

  private static void cadastrarDev() {
    Dev dev = new Dev();
    System.out.print("Nome do Dev: ");
    dev.setNome(scanner.nextLine());
    devs.add(dev);
    System.out.println("Dev cadastrado com sucesso!");
  }

  private static void inscreverDev() {
    Dev dev = escolherDev();
    if (dev != null) {
      dev.inscreverBootcamp(bootcamp);
      System.out.println("Dev inscrito no Bootcamp!");
    }
  }

  private static void devProgredir() {
    Dev dev = escolherDev();
    if (dev != null) {
      dev.progredir();
      System.out.println("Dev avançou no conteúdo!");
    }
  }

  private static void mostrarStatusDev() {
    Dev dev = escolherDev();
    if (dev != null) {
      System.out.println("\n--- Status do Dev " + dev.getNome() + " ---");
      System.out.println("Conteúdos inscritos:");
      dev.getConteudosInscritos().forEach(c -> System.out.println(" - " + c.getTitulo()));

      System.out.println("Conteúdos concluídos:");
      dev.getConteudosFinalizados().forEach(c -> System.out.println(" - " + c.getTitulo()));

      System.out.println("XP total: " + dev.calcularXp());
    }
  }

  private static Dev escolherDev() {
    if (devs.isEmpty()) {
      System.out.println("Nenhum Dev cadastrado.");
      return null;
    }
    System.out.println("Selecione um Dev:");
    for (Dev dev : devs) {
      System.out.println(dev.getNome());
    }
    String escolha = scanner.nextLine();

    Optional<Dev> devOpt = devs.stream()
        .filter(d -> d.getNome().equals(escolha))
        .findFirst();
    if (devOpt.isPresent()) {
      return devOpt.get();
    } else {
      System.out.println("Dev inválido!");
      return null;
    }
  }
}

