package Hamburgueria;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioFinanceiroTest {

    @Test
    void deveGerarRelatorioParaGerente() {
        RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy();
        Funcionario gerente = new Gerente();

        List<String> relatorio = proxy.gerarRelatorio(gerente);

        assertEquals("Relatório financeiro da hamburgueria", relatorio.get(0));
        assertEquals("Total de pedidos: 25", relatorio.get(1));
        assertEquals("Faturamento total: R$ 1250.0", relatorio.get(2));
        assertEquals("Funcionário responsável: Gerente", relatorio.get(3));
    }

    @Test
    void deveRetornarExcecaoParaAtendenteNaoAutorizado() {
        try {
            RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy();
            Funcionario atendente = new Atendente();

            proxy.gerarRelatorio(atendente);

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaCozinhaNaoAutorizada() {
        try {
            RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy();
            Funcionario cozinha = new Cozinha();

            proxy.gerarRelatorio(cozinha);

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}