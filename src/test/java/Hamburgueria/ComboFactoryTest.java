package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboFactoryTest {

    @Test
    void deveCriarComboTradicional() {
        ComboFactory comboFactory = new ComboFactory();

        Combo combo = comboFactory.criarComboTradicional();

        assertEquals("Combo Tradicional", combo.getNome());
        assertEquals(34.0, combo.getPreco());
    }

    @Test
    void deveCriarComboPremium() {
        ComboFactory comboFactory = new ComboFactory();

        Combo combo = comboFactory.criarComboPremium();

        assertEquals("Combo Premium", combo.getNome());
        assertEquals(57.0, combo.getPreco());
    }

    @Test
    void deveCriarComboTradicionalComTresItens() {
        ComboFactory comboFactory = new ComboFactory();

        Combo combo = comboFactory.criarComboTradicional();

        assertEquals(3, combo.getItens().size());
    }

    @Test
    void deveCriarComboPremiumComTresItens() {
        ComboFactory comboFactory = new ComboFactory();

        Combo combo = comboFactory.criarComboPremium();

        assertEquals(3, combo.getItens().size());
    }
}