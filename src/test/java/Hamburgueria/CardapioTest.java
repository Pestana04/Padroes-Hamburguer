package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveAdicionarItemCardapio() {
        Cardapio cardapio = new Cardapio();

        cardapio.adicionarItem(new Hamburguer("X-Burguer", 20.0));

        assertEquals(1, cardapio.getQuantidadeItens());
    }

    @Test
    void deveRetornarValorTotalCardapio() {
        Cardapio cardapio = new Cardapio();

        cardapio.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        cardapio.adicionarItem(new Hamburguer("X-Bacon", 28.0));
        cardapio.adicionarItem(new Hamburguer("Batata", 10.0));

        assertEquals(58.0, cardapio.getValorTotalCardapio());
    }

    @Test
    void deveRetornarDescricaoCardapio() {
        Cardapio cardapio = new Cardapio();

        cardapio.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        cardapio.adicionarItem(new Hamburguer("Batata", 10.0));

        assertEquals("Cardápio | X-Burguer | Batata", cardapio.getDescricaoCardapio());
    }

    @Test
    void devePercorrerItensCardapio() {
        Cardapio cardapio = new Cardapio();

        cardapio.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        cardapio.adicionarItem(new Hamburguer("Batata", 10.0));
        cardapio.adicionarItem(new Hamburguer("Refrigerante", 8.0));

        int quantidade = 0;

        for (ItemCardapio item : cardapio) {
            quantidade++;
        }

        assertEquals(3, quantidade);
    }

    @Test
    void deveRetornarCardapioVazio() {
        Cardapio cardapio = new Cardapio();

        assertEquals(0, cardapio.getQuantidadeItens());
        assertEquals(0.0, cardapio.getValorTotalCardapio());
        assertEquals("Cardápio", cardapio.getDescricaoCardapio());
    }
}