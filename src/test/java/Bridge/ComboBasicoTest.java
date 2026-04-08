package Bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboBasicoTest {

    @Test
    void deveRetornarValorComboBasicoPequeno() {
        Tamanho tamanho = new Pequeno();
        ComboBasico combo = new ComboBasico(20.0f);
        combo.setTamanho(tamanho);
        assertEquals(20.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboBasicoMedio() {
        Tamanho tamanho = new Medio();
        ComboBasico combo = new ComboBasico(20.0f);
        combo.setTamanho(tamanho);
        assertEquals(20.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboBasicoGrande() {
        Tamanho tamanho = new Grande();
        ComboBasico combo = new ComboBasico(20.0f);
        combo.setTamanho(tamanho);
        assertEquals(20.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboBasicoGigante() {
        Tamanho tamanho = new Gigante();
        ComboBasico combo = new ComboBasico(20.0f);
        combo.setTamanho(tamanho);
        assertEquals(20.0f, combo.calcularValorFinal(), 0.01f);
    }
}