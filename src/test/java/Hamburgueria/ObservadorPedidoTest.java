package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObservadorPedidoTest {

    Pedido pedido;
    ObservadorCliente observadorCliente;
    ObservadorCozinha observadorCozinha;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");
        pedido = new Pedido(cliente, "Balcão");

        observadorCliente = new ObservadorCliente();
        observadorCozinha = new ObservadorCozinha();

        pedido.adicionarObservador(observadorCliente);
        pedido.adicionarObservador(observadorCozinha);
    }

    @Test
    void deveNotificarClienteQuandoPedidoEntrarEmPreparo() {
        pedido.preparar();

        assertEquals("Cliente avisado: Pedido alterado para Em Preparo", observadorCliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCozinhaQuandoPedidoEntrarEmPreparo() {
        pedido.preparar();

        assertEquals("Cozinha avisada: Pedido alterado para Em Preparo", observadorCozinha.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteQuandoPedidoFicarPronto() {
        pedido.preparar();
        pedido.deixarPronto();

        assertEquals("Cliente avisado: Pedido alterado para Pronto", observadorCliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCozinhaQuandoPedidoForCancelado() {
        pedido.cancelar();

        assertEquals("Cozinha avisada: Pedido alterado para Cancelado", observadorCozinha.getUltimaNotificacao());
    }
}