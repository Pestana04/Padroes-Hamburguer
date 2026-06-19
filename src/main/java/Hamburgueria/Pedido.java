package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;
import Hamburgueria.interfaces.FormaPagamento;
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
    private String pagamento;

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

    public String realizarPagamento(FormaPagamento formaPagamento) {
        this.pagamento = formaPagamento.pagar(getValorTotal());
        return this.pagamento;
    }

    public PedidoMemento salvarEstado() {
        return new PedidoMemento(this.itens, this.estado, this.pagamento);
    }

    public void restaurarEstado(PedidoMemento pedidoMemento) {
        this.itens = new ArrayList<ItemCardapio>(pedidoMemento.getItens());
        this.estado = pedidoMemento.getEstado();
        this.pagamento = pedidoMemento.getPagamento();

        notificarObservadores("Pedido restaurado para " + estado.getEstado());
    }

    public String getPagamento() {
        return pagamento;
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

        if (pagamento != null) {
            resumo += " | " + pagamento;
        }

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