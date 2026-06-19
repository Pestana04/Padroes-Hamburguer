package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Gustavo", "99999-9999");
        pedido = new Pedido(cliente, "Delivery");
        pedido.adicionarItem(new Hamburguer("X-Burguer", 20.0));
    }

    @Test
    void deveCalcularTaxaEntregaMotoboy() {
        ServicoEntrega entrega = new EntregaPadrao(new EntregaMotoboy());

        assertEquals(8.0, entrega.calcularTaxa(pedido));
    }

    @Test
    void deveCalcularTaxaEntregaAplicativo() {
        ServicoEntrega entrega = new EntregaPadrao(new EntregaAplicativo());

        assertEquals(12.0, entrega.calcularTaxa(pedido));
    }

    @Test
    void deveCalcularTaxaRetiradaBalcao() {
        ServicoEntrega entrega = new EntregaPadrao(new RetiradaBalcao());

        assertEquals(0.0, entrega.calcularTaxa(pedido));
    }

    @Test
    void deveCalcularTaxaEntregaExpressaMotoboy() {
        ServicoEntrega entrega = new EntregaExpressa(new EntregaMotoboy());

        assertEquals(15.0, entrega.calcularTaxa(pedido));
    }

    @Test
    void deveCalcularTotalEntregaPadraoMotoboy() {
        ServicoEntrega entrega = new EntregaPadrao(new EntregaMotoboy());

        assertEquals(28.0, entrega.calcularTotal(pedido));
    }

    @Test
    void deveCalcularTotalEntregaExpressaAplicativo() {
        ServicoEntrega entrega = new EntregaExpressa(new EntregaAplicativo());

        assertEquals(39.0, entrega.calcularTotal(pedido));
    }

    @Test
    void deveRealizarEntregaPadraoMotoboy() {
        ServicoEntrega entrega = new EntregaPadrao(new EntregaMotoboy());

        assertEquals("Entrega Padrão | Motoboy entregando pedido de Gustavo | Total com entrega: R$ 28.0",
                entrega.realizarEntrega(pedido));
    }

    @Test
    void deveRealizarEntregaExpressaAplicativo() {
        ServicoEntrega entrega = new EntregaExpressa(new EntregaAplicativo());

        assertEquals("Entrega Expressa | Aplicativo parceiro entregando pedido de Gustavo | Total com entrega: R$ 39.0",
                entrega.realizarEntrega(pedido));
    }

    @Test
    void deveRealizarRetiradaBalcao() {
        ServicoEntrega entrega = new EntregaPadrao(new RetiradaBalcao());

        assertEquals("Entrega Padrão | Pedido de Gustavo retirado no balcão | Total com entrega: R$ 20.0",
                entrega.realizarEntrega(pedido));
    }

    @Test
    void deveAlterarTipoEntrega() {
        ServicoEntrega entrega = new EntregaPadrao(new EntregaMotoboy());

        entrega.setTipoEntrega(new EntregaAplicativo());

        assertEquals(12.0, entrega.calcularTaxa(pedido));
    }
}