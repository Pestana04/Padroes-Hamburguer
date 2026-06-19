package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoFactoryTest {

    @Test
    void deveCriarPedidoBalcao() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");

        PedidoFactory factory = new PedidoBalcaoFactory();
        Pedido pedido = factory.criarPedido(cliente);

        assertEquals("Balcão", pedido.getTipoPedido());
        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    void deveCriarPedidoDelivery() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");

        PedidoFactory factory = new PedidoDeliveryFactory();
        Pedido pedido = factory.criarPedido(cliente);

        assertEquals("Delivery", pedido.getTipoPedido());
        assertEquals("Recebido", pedido.getNomeEstado());
    }
}