package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPrecoPedidoTest {

    @Test
    void deveCalcularPrecoPedidoComDesconto() {
        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido();

        assertEquals(23.0, calculadora.calcular(20.0, 8.0, 5.0));
    }

    @Test
    void deveCalcularPrecoPedidoSemDesconto() {
        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido();

        assertEquals(28.0, calculadora.calcular(20.0, 8.0, 0.0));
    }

    @Test
    void deveCalcularPrecoPedidoComFormulaPersonalizada() {
        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido("valorPedido + taxaEntrega + desconto");

        assertEquals(33.0, calculadora.calcular(20.0, 8.0, 5.0));
    }

    @Test
    void deveRetornarFormulaPadrao() {
        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido();

        assertEquals("valorPedido + taxaEntrega - desconto", calculadora.getFormula());
    }

    @Test
    void deveRetornarFormulaPersonalizada() {
        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido("valorPedido + taxaEntrega + desconto");

        assertEquals("valorPedido + taxaEntrega + desconto", calculadora.getFormula());
    }

    @Test
    void deveCalcularPrecoPedidoComEntregaExpressa() {
        Pedido pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Delivery");
        pedido.adicionarItem(new Hamburguer("X-Burguer", 20.0));

        ServicoEntrega entrega = new EntregaExpressa(new EntregaMotoboy());

        CalculadoraPrecoPedido calculadora = new CalculadoraPrecoPedido();

        assertEquals(30.0, calculadora.calcular(
                pedido.getValorTotal(),
                entrega.calcularTaxa(pedido),
                5.0
        ));
    }
}