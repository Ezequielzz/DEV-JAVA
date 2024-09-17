package Ex1;
import java.util.Scanner;

public class AprovaAluno {
    public void rodar() {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;
        boolean bonus = true;

        // Capturar as notas de cada disciplina
        for (int i = 0; i < notas.length; i++) {
            System.out.println("\nDigite a nota da disciplina " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];

            // Verificando as notas para aplicar a condição de bonus
            if (notas[i] <= 9) {
                bonus = false;
            }
        }

        // Calculando a média
        double media = soma / notas.length;

        // Aplicando o bonus se necessário
        if (bonus) {
            media += media * 0.10;
        }

        String status;
        if (media >= 7) {
            status = "Aprovado";
        } else if (media >= 5 && media < 7) {
            status = "Recuperação";
        } else {
            status = "Reprovado";
        }

        System.out.println("Média final: " + media);
        System.out.println("Situação do Aluno: " + status);

        scanner.close();
    }
}