package Bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboPremiumTest {

    @Test
    void deveRetornarValorComboPremiumPequeno() {
        Tamanho tamanho = new Pequeno();
        ComboPremium combo = new ComboPremium(30.0f);
        combo.setTamanho(tamanho);
        assertEquals(30.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboPremiumMedio() {
        Tamanho tamanho = new Medio();
        ComboPremium combo = new ComboPremium(30.0f);
        combo.setTamanho(tamanho);
        assertEquals(33.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboPremiumGrande() {
        Tamanho tamanho = new Grande();
        ComboPremium combo = new ComboPremium(30.0f);
        combo.setTamanho(tamanho);
        assertEquals(36.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboPremiumGigante() {
        Tamanho tamanho = new Gigante();
        ComboPremium combo = new ComboPremium(30.0f);
        combo.setTamanho(tamanho);
        assertEquals(39.0f, combo.calcularValorFinal(), 0.01f);
    }
}