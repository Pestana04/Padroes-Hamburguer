package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemCardapio> itens = new ArrayList<ItemCardapio>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public double getValorTotal() {
        double total = 0.0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public String getResumo() {
        String resumo = "Pedido de " + cliente.getNome();

        for (ItemCardapio item : itens) {
            resumo += " | " + item.getDescricao();
        }

        resumo += " | Total: " + getValorTotal();

        return resumo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}