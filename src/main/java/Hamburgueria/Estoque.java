package Hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private static Estoque instancia;
    private Map<String, Integer> produtos = new HashMap<String, Integer>();

    private Estoque() {}

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionarProduto(String produto, int quantidade) {
        produtos.put(produto, quantidade);
    }

    public int getQuantidade(String produto) {
        return produtos.getOrDefault(produto, 0);
    }

    public boolean baixarProduto(String produto, int quantidade) {
        int quantidadeAtual = getQuantidade(produto);

        if (quantidadeAtual >= quantidade) {
            produtos.put(produto, quantidadeAtual - quantidade);
            return true;
        }

        return false;
    }
}