package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoEstadoTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");
        pedido = new Pedido(cliente, "Balcão");
    }

    @Test
    void deveRetornarEstadoInicialRecebido() {
        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    void devePrepararPedidoRecebido() {
        assertTrue(pedido.preparar());
        assertEquals("Em Preparo", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarPedidoRecebido() {
        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveFinalizarPedidoRecebido() {
        assertFalse(pedido.finalizar());
        assertEquals("Recebido", pedido.getNomeEstado());
    }

    @Test
    void deveDeixarPedidoEmPreparoPronto() {
        pedido.preparar();

        assertTrue(pedido.deixarPronto());
        assertEquals("Pronto", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarPedidoEmPreparo() {
        pedido.preparar();

        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDevePrepararPedidoEmPreparo() {
        pedido.preparar();

        assertFalse(pedido.preparar());
        assertEquals("Em Preparo", pedido.getNomeEstado());
    }

    @Test
    void deveFinalizarPedidoPronto() {
        pedido.preparar();
        pedido.deixarPronto();

        assertTrue(pedido.finalizar());
        assertEquals("Finalizado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveCancelarPedidoPronto() {
        pedido.preparar();
        pedido.deixarPronto();

        assertFalse(pedido.cancelar());
        assertEquals("Pronto", pedido.getNomeEstado());
    }

    @Test
    void naoDevePrepararPedidoFinalizado() {
        pedido.preparar();
        pedido.deixarPronto();
        pedido.finalizar();

        assertFalse(pedido.preparar());
        assertEquals("Finalizado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveFinalizarPedidoCancelado() {
        pedido.cancelar();

        assertFalse(pedido.finalizar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }
}