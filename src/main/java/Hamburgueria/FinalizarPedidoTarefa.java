package Hamburgueria;

import Hamburgueria.interfaces.Tarefa;

public class FinalizarPedidoTarefa implements Tarefa {

    private Pedido pedido;
    private PedidoMemento estadoAnterior;
    private boolean executada;

    public FinalizarPedidoTarefa(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        this.estadoAnterior = pedido.salvarEstado();
        this.executada = pedido.finalizar();
    }

    public void cancelar() {
        if (executada) {
            pedido.restaurarEstado(estadoAnterior);
            this.executada = false;
        }
    }
}