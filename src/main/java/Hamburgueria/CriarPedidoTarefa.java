package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import Hamburgueria.interfaces.Tarefa;

public class CriarPedidoTarefa implements Tarefa {

    private Pedido pedido;
    private ItemCardapio item;
    private PedidoMemento estadoAnterior;
    private boolean executada;

    public CriarPedidoTarefa(Pedido pedido, ItemCardapio item) {
        this.pedido = pedido;
        this.item = item;
    }

    public void executar() {
        this.estadoAnterior = pedido.salvarEstado();
        pedido.adicionarItem(item);
        this.executada = true;
    }

    public void cancelar() {
        if (executada) {
            pedido.restaurarEstado(estadoAnterior);
            this.executada = false;
        }
    }
}