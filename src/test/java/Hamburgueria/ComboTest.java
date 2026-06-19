package Hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    @Test
    void deveRetornarDescricaoCombo() {
        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));

        assertEquals("Combo: Combo Tradicional + X-Burguer + Batata", combo.getDescricao());
    }

    @Test
    void deveRetornarPrecoCombo() {
        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));
        combo.adicionarItem(new Hamburguer("Refrigerante", 8.0));

        assertEquals(38.0, combo.getPreco());
    }

    @Test
    void deveRetornarComboSemItens() {
        Combo combo = new Combo("Combo Vazio");

        assertEquals("Combo: Combo Vazio", combo.getDescricao());
        assertEquals(0.0, combo.getPreco());
    }
}