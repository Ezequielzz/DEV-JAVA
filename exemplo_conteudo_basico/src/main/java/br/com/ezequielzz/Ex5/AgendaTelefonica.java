package br.com.ezequielzz.Ex5;

public class AgendaTelefonica {
    private Contato[] contatos;
    private int contador;

    public AgendaTelefonica(int maxContato) {
        contatos = new Contato[maxContato];
        contador = 0;
    }

    public void addContato(Contato contato) throws AgendaException {
        if (contador >= contatos.length) {
            throw new AgendaException("Agenda cheia");
        }
        contatos[contador] = contato;
        contador++;
    }

    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia!");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }

    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado");
    }

    public boolean removerContato(String nome) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                // Remove o contato e ajusta o array
                for (int j = i; j < contador - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false; // Retorna false se o contato não for encontrado
    }
}
