package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredienteFactoryTest {

    @BeforeEach
    void setUp() {
        IngredienteFactory.limparIngredientes();
    }

    @Test
    void deveCriarIngrediente() {
        Ingrediente ingrediente = IngredienteFactory.getIngrediente("Pão", "Massa");

        assertEquals("Pão", ingrediente.getNome());
        assertEquals("Massa", ingrediente.getTipo());
        assertEquals("Pão (Massa)", ingrediente.getDescricao());
    }

    @Test
    void deveReutilizarIngredienteExistente() {
        Ingrediente ingrediente1 = IngredienteFactory.getIngrediente("Pão", "Massa");
        Ingrediente ingrediente2 = IngredienteFactory.getIngrediente("Pão", "Massa");

        assertEquals(ingrediente1, ingrediente2);
        assertEquals(1, IngredienteFactory.getTotalIngredientes());
    }

    @Test
    void deveCriarIngredientesDiferentes() {
        IngredienteFactory.getIngrediente("Pão", "Massa");
        IngredienteFactory.getIngrediente("Carne", "Proteína");
        IngredienteFactory.getIngrediente("Queijo", "Laticínio");

        assertEquals(3, IngredienteFactory.getTotalIngredientes());
    }

    @Test
    void deveLimparIngredientes() {
        IngredienteFactory.getIngrediente("Pão", "Massa");
        IngredienteFactory.getIngrediente("Carne", "Proteína");

        IngredienteFactory.limparIngredientes();

        assertEquals(0, IngredienteFactory.getTotalIngredientes());
    }
}