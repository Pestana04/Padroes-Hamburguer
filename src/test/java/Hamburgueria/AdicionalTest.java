package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdicionalTest {

    @Test
    void deveAdicionarBaconAoHamburguer() {
        ItemCardapio hamburguer = new AdicionalBacon(new Hamburguer("X-Burguer", 20.0));

        assertEquals("X-Burguer + Bacon", hamburguer.getDescricao());
        assertEquals(25.0, hamburguer.getPreco());
    }

    @Test
    void deveAdicionarCheddarAoHamburguer() {
        ItemCardapio hamburguer = new AdicionalCheddar(new Hamburguer("X-Burguer", 20.0));

        assertEquals("X-Burguer + Cheddar", hamburguer.getDescricao());
        assertEquals(24.0, hamburguer.getPreco());
    }

    @Test
    void deveAdicionarOvoAoHamburguer() {
        ItemCardapio hamburguer = new AdicionalOvo(new Hamburguer("X-Burguer", 20.0));

        assertEquals("X-Burguer + Ovo", hamburguer.getDescricao());
        assertEquals(23.0, hamburguer.getPreco());
    }

    @Test
    void deveAdicionarVariosAdicionaisAoHamburguer() {
        ItemCardapio hamburguer = new AdicionalBacon(
                new AdicionalCheddar(
                        new AdicionalOvo(
                                new Hamburguer("X-Burguer", 20.0)
                        )
                )
        );

        assertEquals("X-Burguer + Ovo + Cheddar + Bacon", hamburguer.getDescricao());
        assertEquals(32.0, hamburguer.getPreco());
    }
}