package Ex6;

public class Item {
    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return nome + "," + quantidade;
    }

    public static Item fromString(String linha) {
        String[] partes = linha.split(",");
        return new Item(partes[0], Integer.parseInt(partes[1]));
    }
}

