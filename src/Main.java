import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = criarCurso("curso java", "descrição curso java", 8);
        Curso curso2 = criarCurso("curso js", "descrição curso js", 4);
        Mentoria mentoria = criarMentoria("mentoria de java", "descrição mentoria java", LocalDateTime.now());

        List<Conteudo> conteudos = new ArrayList<>();
        conteudos.add(curso1);
        conteudos.add(curso2);
        conteudos.add(mentoria);

        Bootcamp bootcamp = criarBootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer",conteudos);

        Dev devCamila = criarDev("Camila", bootcamp);
        simularProgresso(devCamila, 2);

        System.out.println("-------");

        Dev devJoao = criarDev("Joao", bootcamp);
        simularProgresso(devJoao, 3);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao, LocalDateTime data) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(data);
        return mentoria;
    }

    private static Bootcamp criarBootcamp(String nome, String descricao, List<Conteudo> conteudoList) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        bootcamp.getConteudos().addAll(conteudoList);
        return bootcamp;
    }


    private static Dev criarDev(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + nome + ": " + dev.getConteudosInscritos());
        return dev;
    }

    private static void simularProgresso(Dev dev, int progresso) {
        for (int i = 0; i < progresso; i++) {
            dev.progredir();
        }
        System.out.println("-");
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());
    }
}
