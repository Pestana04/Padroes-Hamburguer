package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerBuilderTest {

    @Test
    void deveRetornarExcecaoParaHamburguerSemNome() {
        try {
            HamburguerBuilder hamburguerBuilder = new HamburguerBuilder();

            Hamburguer hamburguer = hamburguerBuilder
                    .setPreco(20.0)
                    .build();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaHamburguerSemPreco() {
        try {
            HamburguerBuilder hamburguerBuilder = new HamburguerBuilder();

            Hamburguer hamburguer = hamburguerBuilder
                    .setNome("X-Burguer")
                    .build();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarHamburguerValido() {
        HamburguerBuilder hamburguerBuilder = new HamburguerBuilder();

        Hamburguer hamburguer = hamburguerBuilder
                .setNome("X-Burguer")
                .setPreco(20.0)
                .adicionarIngrediente("Pão", "Massa")
                .adicionarIngrediente("Carne", "Proteína")
                .build();

        assertNotNull(hamburguer);
    }

    @Test
    void deveRetornarDescricaoHamburguerComIngredientes() {
        HamburguerBuilder hamburguerBuilder = new HamburguerBuilder();

        Hamburguer hamburguer = hamburguerBuilder
                .setNome("X-Burguer")
                .setPreco(20.0)
                .adicionarIngrediente("Pão", "Massa")
                .adicionarIngrediente("Carne", "Proteína")
                .build();

        assertEquals("X-Burguer com Pão (Massa), Carne (Proteína)", hamburguer.getDescricao());
    }
}