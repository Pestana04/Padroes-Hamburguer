package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoMementoTest {

    @Test
    void deveSalvarEstadoPedido() {
        Pedido pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Balcão");

        PedidoMemento memento = pedido.salvarEstado();

        assertEquals("Recebido", memento.getEstado().getEstado());
    }

    @Test
    void deveRestaurarEstadoPedido() {
        Pedido pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Balcão");

        PedidoMemento memento = pedido.salvarEstado();

        pedido.preparar();
        pedido.deixarPronto();

        pedido.restaurarEstado(memento);

        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    void deveRestaurarItensPedido() {
        Pedido pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Balcão");

        pedido.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        PedidoMemento memento = pedido.salvarEstado();

        pedido.adicionarItem(new Hamburguer("Batata", 10.0));

        pedido.restaurarEstado(memento);

        assertEquals(20.0, pedido.getValorTotal());
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveRestaurarPagamentoPedido() {
        Pedido pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Balcão");

        pedido.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        pedido.realizarPagamento(new PagamentoPix());

        PedidoMemento memento = pedido.salvarEstado();

        pedido.realizarPagamento(new PagamentoDinheiro());

        pedido.restaurarEstado(memento);

        assertEquals("Pagamento via Pix realizado no valor de R$ 20.0", pedido.getPagamento());
    }
}