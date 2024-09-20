package br.com.ezequielzz.Ex5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contato {
    // Atributos
    private String nome;
    private String telefone;

    // Métodos
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone;
    }
}
