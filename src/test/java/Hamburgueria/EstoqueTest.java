package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = Estoque.getInstancia();
        estoque.adicionarProduto("Pao", 10);
        estoque.adicionarProduto("Carne", 5);
    }

    @Test
    void deveRetornarMesmaInstanciaEstoque() {
        Estoque estoque1 = Estoque.getInstancia();
        Estoque estoque2 = Estoque.getInstancia();

        assertEquals(estoque1, estoque2);
    }

    @Test
    void deveAdicionarProdutoEstoque() {
        estoque.adicionarProduto("Queijo", 8);

        assertEquals(8, estoque.getQuantidade("Queijo"));
    }

    @Test
    void deveBaixarProdutoEstoque() {
        assertTrue(estoque.baixarProduto("Pao", 2));
        assertEquals(8, estoque.getQuantidade("Pao"));
    }

    @Test
    void naoDeveBaixarProdutoSemQuantidadeSuficiente() {
        assertFalse(estoque.baixarProduto("Carne", 10));
        assertEquals(5, estoque.getQuantidade("Carne"));
    }

    @Test
    void deveRetornarZeroParaProdutoInexistente() {
        assertEquals(0, estoque.getQuantidade("Bacon"));
    }
}