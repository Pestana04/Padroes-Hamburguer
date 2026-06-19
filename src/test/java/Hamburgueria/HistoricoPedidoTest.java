package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoPedidoTest {

    Pedido pedido;
    HistoricoPedido historicoPedido;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");
        pedido = new Pedido(cliente, "Balcão");
        historicoPedido = new HistoricoPedido();
    }

    @Test
    void deveExecutarCriacaoPedido() {
        CriarPedidoTarefa tarefa = new CriarPedidoTarefa(pedido, new Hamburguer("X-Burguer", 20.0));

        historicoPedido.executarTarefa(tarefa);

        assertEquals(20.0, pedido.getValorTotal());
        assertEquals(1, historicoPedido.getQuantidadeTarefas());
    }

    @Test
    void deveCancelarCriacaoPedido() {
        CriarPedidoTarefa tarefa = new CriarPedidoTarefa(pedido, new Hamburguer("X-Burguer", 20.0));

        historicoPedido.executarTarefa(tarefa);
        historicoPedido.cancelarUltimaTarefa();

        assertEquals(0.0, pedido.getValorTotal());
        assertEquals(0, historicoPedido.getQuantidadeTarefas());
    }

    @Test
    void deveExecutarCancelamentoPedido() {
        CancelarPedidoTarefa tarefa = new CancelarPedidoTarefa(pedido);

        historicoPedido.executarTarefa(tarefa);

        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarCancelamentoPedido() {
        CancelarPedidoTarefa tarefa = new CancelarPedidoTarefa(pedido);

        historicoPedido.executarTarefa(tarefa);
        historicoPedido.cancelarUltimaTarefa();

        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    void deveExecutarFinalizacaoPedido() {
        pedido.preparar();
        pedido.deixarPronto();

        FinalizarPedidoTarefa tarefa = new FinalizarPedidoTarefa(pedido);
        historicoPedido.executarTarefa(tarefa);

        assertEquals("Finalizado", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarFinalizacaoPedido() {
        pedido.preparar();
        pedido.deixarPronto();

        FinalizarPedidoTarefa tarefa = new FinalizarPedidoTarefa(pedido);

        historicoPedido.executarTarefa(tarefa);
        historicoPedido.cancelarUltimaTarefa();

        assertEquals("Pronto", pedido.getNomeEstado());
    }
}