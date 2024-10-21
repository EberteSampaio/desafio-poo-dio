package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp.getDevsInscritos().contains(this)) {
            System.out.println("Você já está inscrito nesse bootcamp.");
        } else {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        }
    }

    public void progredir() {
        // Usa Optional de forma mais elegante
        this.conteudosInscritos.stream().findFirst().ifPresentOrElse(conteudo -> {
            this.conteudosConcluidos.add(conteudo);
            this.conteudosInscritos.remove(conteudo);
        }, () -> System.err.println("Você não está matriculado em nenhum conteúdo!"));
    }

    public double calcularTotalXp() {

        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
