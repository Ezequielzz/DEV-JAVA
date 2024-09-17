package Ex3;

class Divisao extends Operacao {
    @Override
    public double calcular(double a, double b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        }
        return a / b;
    }
}