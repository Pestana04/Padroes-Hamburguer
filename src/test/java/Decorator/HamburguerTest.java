package Decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HamburguerTest {

    @Test
    void deveRetornarHamburguerSimples() {
        Hamburguer hamburguer = new HamburguerSimples(10f);

        assertEquals(10f, hamburguer.getValor(), 0.01f);
        assertEquals("Hamburguer simples", hamburguer.getDescricao());
    }

    @Test
    void deveAdicionarQueijo() {
        Hamburguer hamburguer = new HamburguerSimples(10f);
        hamburguer = new Queijo(hamburguer);

        assertEquals(11f, hamburguer.getValor(), 0.01f);
        assertEquals("Hamburguer simples, queijo", hamburguer.getDescricao());
    }

    @Test
    void deveAdicionarBacon() {
        Hamburguer hamburguer = new HamburguerSimples(10f);
        hamburguer = new Bacon(hamburguer);

        assertEquals(12f, hamburguer.getValor(), 0.01f);
        assertEquals("Hamburguer simples, bacon", hamburguer.getDescricao());
    }

    @Test
    void deveAdicionarMultiplosIngredientes() {
        Hamburguer hamburguer = new HamburguerSimples(10f);
        hamburguer = new Queijo(hamburguer);
        hamburguer = new Bacon(hamburguer);

        assertEquals(13.2f, hamburguer.getValor(), 0.01f);
        assertEquals("Hamburguer simples, queijo, bacon", hamburguer.getDescricao());
    }
}