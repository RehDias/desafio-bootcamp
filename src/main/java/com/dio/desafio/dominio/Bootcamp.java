package com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bootcamp {
  private String nome;
  private String descricao;
  private LocalDate dataInicio = LocalDate.now();
  private LocalDate dataFim = dataInicio.plusDays(45);
  private Set<Dev> devsInscritos = new HashSet<>();
  private Set<Conteudo> conteudos = new LinkedHashSet<>();

  public void adicionarConteudos(Conteudo conteudo) {
    this.conteudos.add(conteudo);
  }

  public void adicionarDev(Dev dev) {
    this.devsInscritos.add(dev);
  }
}
