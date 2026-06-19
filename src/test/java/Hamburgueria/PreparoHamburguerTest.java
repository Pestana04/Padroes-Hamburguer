package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparoHamburguerTest {

    @BeforeEach
    void setUp() {
        IngredienteFactory.limparIngredientes();
    }

    @Test
    void devePrepararHamburguerTradicional() {
        PreparoHamburguer preparo = new PreparoHamburguerTradicional();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("X-Burguer Tradicional", hamburguer.getNome());
        assertEquals(20.0, hamburguer.getPreco());
        assertEquals(4, hamburguer.getIngredientes().size());
    }

    @Test
    void devePrepararHamburguerPremium() {
        PreparoHamburguer preparo = new PreparoHamburguerPremium();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("X-Bacon Premium", hamburguer.getNome());
        assertEquals(30.0, hamburguer.getPreco());
        assertEquals(5, hamburguer.getIngredientes().size());
    }

    @Test
    void devePrepararHamburguerVegano() {
        PreparoHamburguer preparo = new PreparoHamburguerVegano();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("Hamburguer Vegano", hamburguer.getNome());
        assertEquals(25.0, hamburguer.getPreco());
        assertEquals(4, hamburguer.getIngredientes().size());
    }

    @Test
    void deveRetornarDescricaoHamburguerTradicional() {
        PreparoHamburguer preparo = new PreparoHamburguerTradicional();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("X-Burguer Tradicional com Pão Tradicional (Massa), Carne Bovina (Proteína), Queijo Mussarela (Laticínio), Molho da Casa (Molho)",
                hamburguer.getDescricao());
    }

    @Test
    void deveRetornarDescricaoHamburguerPremium() {
        PreparoHamburguer preparo = new PreparoHamburguerPremium();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("X-Bacon Premium com Pão Brioche (Massa), Carne Angus (Proteína), Queijo Cheddar (Laticínio), Molho Especial (Molho), Bacon (Proteína)",
                hamburguer.getDescricao());
    }

    @Test
    void deveRetornarDescricaoHamburguerVegano() {
        PreparoHamburguer preparo = new PreparoHamburguerVegano();

        Hamburguer hamburguer = preparo.preparar();

        assertEquals("Hamburguer Vegano com Pão Integral (Massa), Hamburguer de Grão-de-Bico (Proteína Vegetal), Queijo Vegano (Vegetal), Molho Verde (Molho)",
                hamburguer.getDescricao());
    }
}