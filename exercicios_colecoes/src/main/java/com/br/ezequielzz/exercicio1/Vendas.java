package com.br.ezequielzz.exercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class Vendas {
    // Atributos
    private Map<String, List<Produto>> vendasCpf;

    public Vendas() {
        vendasCpf = new HashMap<>();
    }

    // Métodos

    // Cadastrar Venda
    public void cadastroVenda(String cpf, Produto produto) {
        for (String cpfUsuario : vendasCpf.keySet()) {
            if (cpfUsuario.equals(cpf)) {
                List<Produto> produtosCpf = vendasCpf.get(cpf);
                produtosCpf.add(produto);
                vendasCpf.put(cpf, produtosCpf);
                return;
            }
        }
        List<Produto> produtosCpfVazio = new ArrayList<>();
        produtosCpfVazio.add(produto);
        vendasCpf.put(cpf, produtosCpfVazio);
    }

    // Listar Venda
    public List<Produto> listaProdutos(String cpf) {
        List<Produto> listaCpf = vendasCpf.getOrDefault(cpf, Collections.emptyList());
        return listaCpf;
    }

    // Listar Venda com Filtro (Stream)
    public List<Produto> listaProdutosFiltro(String cpf, double valorMinimo) throws Exception {
        List<Produto> listaCpfFiltro = vendasCpf.getOrDefault(cpf, Collections.emptyList());
        if (listaCpfFiltro.isEmpty()) {
            throw new Exception("CPF não encontrado!");
        } else {
            List<Produto> resultado = listaCpfFiltro.stream()
                    .filter(p -> p.getPreco() >= valorMinimo)
                    .collect(Collectors.toList());
            return resultado;
        }
    }
}
