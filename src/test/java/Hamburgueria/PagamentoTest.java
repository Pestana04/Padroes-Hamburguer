package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");
        pedido = new Pedido(cliente, "Balcão");
        pedido.adicionarItem(new Hamburguer("X-Burguer", 20.0));
    }

    @Test
    void deveRealizarPagamentoPix() {
        assertEquals("Pagamento via Pix realizado no valor de R$ 20.0", pedido.realizarPagamento(new PagamentoPix()));
    }

    @Test
    void deveRealizarPagamentoCartao() {
        assertEquals("Pagamento via Cartão realizado no valor de R$ 20.0", pedido.realizarPagamento(new PagamentoCartao()));
    }

    @Test
    void deveRealizarPagamentoDinheiro() {
        assertEquals("Pagamento em Dinheiro realizado no valor de R$ 20.0", pedido.realizarPagamento(new PagamentoDinheiro()));
    }

    @Test
    void deveRealizarPagamentoOnlineAdapter() {
        SistemaPagamentoOnline sistemaPagamentoOnline = new SistemaPagamentoOnline();

        assertEquals("Pagamento online externo autorizado no valor de R$ 20.0",
                pedido.realizarPagamento(new PagamentoOnlineAdapter(sistemaPagamentoOnline)));
    }

    @Test
    void deveArmazenarPagamentoPedido() {
        pedido.realizarPagamento(new PagamentoPix());

        assertEquals("Pagamento via Pix realizado no valor de R$ 20.0", pedido.getPagamento());
    }
}