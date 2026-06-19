package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;
import Hamburgueria.interfaces.ItemCardapio;
import Hamburgueria.interfaces.ObservadorPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private String tipoPedido;
    private List<ItemCardapio> itens = new ArrayList<ItemCardapio>();
    private EstadoPedido estado;
    private List<ObservadorPedido> observadores = new ArrayList<ObservadorPedido>();

    public Pedido(Cliente cliente, String tipoPedido) {
        this.cliente = cliente;
        this.tipoPedido = tipoPedido;
        this.estado = EstadoPedidoRecebido.getInstance();
    }

    public void adicionarItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public void adicionarObservador(ObservadorPedido observador) {
        this.observadores.add(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificarObservadores("Pedido alterado para " + estado.getEstado());
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean deixarPronto() {
        return estado.deixarPronto(this);
    }

    public boolean finalizar() {
        return estado.finalizar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public double getValorTotal() {
        double total = 0.0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public String getResumo() {
        String resumo = "Pedido " + tipoPedido + " de " + cliente.getNome();

        for (ItemCardapio item : itens) {
            resumo += " | " + item.getDescricao();
        }

        resumo += " | Situação: " + getNomeEstado();
        resumo += " | Total: " + getValorTotal();

        return resumo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }
}