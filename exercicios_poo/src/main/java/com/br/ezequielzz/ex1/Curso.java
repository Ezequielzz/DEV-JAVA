package com.br.ezequielzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private String nomeCurso = "Inglês";
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;

    public void addAluno() {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.println("Digite o nome do Aluno:");
        aluno.setNome(scanner.nextLine());

        System.out.println("Digite o CPF do Aluno:");
        aluno.setCpf(scanner.nextLine());

        System.out.println("Digite a matrícula do Aluno:");
        aluno.setMatricula(scanner.nextInt());

        aluno.exibirInformacoes();
        alunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso!\n");
    }

    public void addProfessor() {
        if (this.professor != null) {
            System.out.println("Já existe um professor atribuído ao curso.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        professor = new Professor();

        System.out.println("Digite o nome do Professor:");
        professor.setNome(scanner.nextLine());

        System.out.println("Digite o CPF do Professor:");
        professor.setCpf(scanner.nextLine());

        System.out.println("Digite o salário do Professor:");
        professor.setSalario(scanner.nextInt());

        professor.exibirInformacoes();
        System.out.println("Professor atribuído ao curso com sucesso!\n");
    }

    public void atribuirNotas(Scanner scanner) {
        try {
            int quantidadeNotas = 4;
            scanner.nextLine();  // Limpa o buffer após o uso de nextInt() no menu
            System.out.println("Digite o nome do Aluno:");
            String nomeAluno = scanner.nextLine();
            boolean encontrado = false;

            for (Aluno aluno : alunos) {
                if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                    for (int i = 0; i < quantidadeNotas; i++) {
                        System.out.println("Digite a nota " + (i + 1) + " do aluno " + aluno.getNome() + ": ");
                        aluno.addNota(scanner.nextDouble());
                    }
                    aluno.avaliarDesempenho();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Aluno não encontrado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void resultadoFinal() {
        for (Aluno aluno : alunos) {
            aluno.exibirInformacoes();
            aluno.avaliarDesempenho();
        }
    }

    public void exibirDetalhesCurso() {
        System.out.println("\n=== Detalhes do Curso " + nomeCurso + " ===");
        if (professor != null) {
            System.out.println("Professor do Curso: " + professor.getNome());
        } else {
            System.out.println("Nenhum professor encontrado!");
        }

        if (!alunos.isEmpty()) {
            try {
                System.out.println("\nLista de Alunos:");
                for (Aluno aluno : alunos) {
                    aluno.exibirInformacoes();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Nenhum aluno encontrado!");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar Aluno");
            System.out.println("2 - Atribuir Professor");
            System.out.println("3 - Atribuir Notas");
            System.out.println("4 - Visualizar Aluno");
            System.out.println("5 - Exibir Detalhes do Curso");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer após o uso de nextInt()

            switch (opcao) {
                case 1:
                    addAluno();  // Chama o método para adicionar Aluno
                    break;
                case 2:
                    addProfessor();  // Chama o método para atribuir o professor
                    break;
                case 3:
                    atribuirNotas(scanner);  // Atribuir nota ao aluno
                    break;
                case 4:
                    resultadoFinal();  // Atribuir nota ao aluno
                    break;
                case 5:
                    exibirDetalhesCurso();  // Exibe os detalhes do curso
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);  // Continua até o usuário escolher "Sair"
    }
}
