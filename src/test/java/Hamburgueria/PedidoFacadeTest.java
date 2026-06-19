package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoFacadeTest {

    @Test
    void deveCriarPedidoBalcaoTradicional() {
        PedidoFacade pedidoFacade = new PedidoFacade();

        Pedido pedido = pedidoFacade.criarPedidoBalcaoTradicional("Gustavo", "99999-9999");

        assertEquals("Balcão", pedido.getTipoPedido());
        assertEquals("Recebido", pedido.getNomeEstado());
        assertEquals(34.0, pedido.getValorTotal());
    }

    @Test
    void deveCriarPedidoDeliveryPremium() {
        PedidoFacade pedidoFacade = new PedidoFacade();

        Pedido pedido = pedidoFacade.criarPedidoDeliveryPremium("Gustavo", "99999-9999");

        assertEquals("Delivery", pedido.getTipoPedido());
        assertEquals("Recebido", pedido.getNomeEstado());
        assertEquals(57.0, pedido.getValorTotal());
    }

    @Test
    void deveRetornarResumoPedidoBalcaoTradicional() {
        PedidoFacade pedidoFacade = new PedidoFacade();

        Pedido pedido = pedidoFacade.criarPedidoBalcaoTradicional("Gustavo", "99999-9999");

        assertTrue(pedido.getResumo().contains("Pedido Balcão de Gustavo"));
        assertTrue(pedido.getResumo().contains("Situação: Recebido"));
        assertTrue(pedido.getResumo().contains("Total: 34.0"));
    }
}