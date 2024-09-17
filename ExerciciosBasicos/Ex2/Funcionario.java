package Ex2;
public class Funcionario {
    String nome;
    int idade;
    double salario;

    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Idade: " + idade + " Salario: " + salario;
    }
}
