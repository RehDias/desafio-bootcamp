package com.dio.desafio.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract class Conteudo {
  protected String titulo;
  protected String descricao;
  public static final double XP_PADRAO = 10d;

  public abstract double calcularXp();
}
