package Ex4;

// Exceção personalizada para valores inválidos
class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String mensagem) {
        super(mensagem);
    }
}