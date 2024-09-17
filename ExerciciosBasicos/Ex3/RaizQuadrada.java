package Ex3;

class RaizQuadrada extends Operacao {
    @Override
    public double calcular(double a, double b) throws Exception {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }

    // Sobrecarga para raiz quadrada de um número sem o segundo parâmetro
    public double calcular(double a) throws Exception {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }
}
