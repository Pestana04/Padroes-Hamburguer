package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioPrototypeFactoryTest {

    @BeforeEach
    void setUp() {
        CardapioPrototypeFactory.limparModelos();
        IngredienteFactory.limparIngredientes();
    }

    @Test
    void deveAdicionarModeloCardapio() {
        Hamburguer hamburguer = new Hamburguer("X-Burguer", 20.0);

        CardapioPrototypeFactory.adicionarModelo("xburguer", hamburguer);

        assertEquals(1, CardapioPrototypeFactory.getQuantidadeModelos());
    }

    @Test
    void deveClonarHamburguer() {
        Hamburguer hamburguer = new PreparoHamburguerPremium().preparar();

        CardapioPrototypeFactory.adicionarModelo("premium", hamburguer);

        Hamburguer clone = (Hamburguer) CardapioPrototypeFactory.clonarModelo("premium");

        assertEquals(hamburguer.getDescricao(), clone.getDescricao());
        assertEquals(hamburguer.getPreco(), clone.getPreco());
    }

    @Test
    void deveClonarHamburguerSemAlterarOriginal() {
        Hamburguer hamburguer = new PreparoHamburguerTradicional().preparar();

        CardapioPrototypeFactory.adicionarModelo("tradicional", hamburguer);

        Hamburguer clone = (Hamburguer) CardapioPrototypeFactory.clonarModelo("tradicional");
        clone.adicionarIngrediente(new Ingrediente("Cebola", "Vegetal"));

        assertEquals(4, hamburguer.getIngredientes().size());
        assertEquals(5, clone.getIngredientes().size());
    }

    @Test
    void deveClonarCombo() {
        Combo combo = new Combo("Combo Teste");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));

        CardapioPrototypeFactory.adicionarModelo("combo", combo);

        Combo clone = (Combo) CardapioPrototypeFactory.clonarModelo("combo");

        assertEquals(combo.getDescricao(), clone.getDescricao());
        assertEquals(combo.getPreco(), clone.getPreco());
    }

    @Test
    void deveClonarComboSemAlterarOriginal() {
        Combo combo = new Combo("Combo Teste");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));

        CardapioPrototypeFactory.adicionarModelo("combo", combo);

        Combo clone = (Combo) CardapioPrototypeFactory.clonarModelo("combo");
        clone.adicionarItem(new Hamburguer("Batata", 10.0));

        assertEquals(1, combo.getItens().size());
        assertEquals(2, clone.getItens().size());
    }

    @Test
    void deveRetornarExcecaoParaModeloInexistente() {
        try {
            ItemCardapio item = CardapioPrototypeFactory.clonarModelo("inexistente");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Modelo não encontrado", e.getMessage());
        }
    }
}