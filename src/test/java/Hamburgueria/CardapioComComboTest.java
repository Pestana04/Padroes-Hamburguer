package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioComComboTest {

    @Test
    void deveAdicionarComboAoCardapio() {
        Cardapio cardapio = new Cardapio();

        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));

        cardapio.adicionarItem(combo);

        assertEquals(1, cardapio.getQuantidadeItens());
        assertEquals(30.0, cardapio.getValorTotalCardapio());
    }

    @Test
    void deveRetornarDescricaoCardapioComCombo() {
        Cardapio cardapio = new Cardapio();

        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));

        cardapio.adicionarItem(combo);

        assertEquals("Cardápio | Combo: Combo Tradicional + X-Burguer + Batata",
                cardapio.getDescricaoCardapio());
    }
}