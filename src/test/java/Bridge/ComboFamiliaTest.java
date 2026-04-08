package Bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboFamiliaTest {

    @Test
    void deveRetornarValorComboFamiliaPequeno() {
        Tamanho tamanho = new Pequeno();
        ComboFamilia combo = new ComboFamilia(25.0f);
        combo.setTamanho(tamanho);
        combo.setQuantidadePessoas(2);
        assertEquals(50.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboFamiliaMedio() {
        Tamanho tamanho = new Medio();
        ComboFamilia combo = new ComboFamilia(25.0f);
        combo.setTamanho(tamanho);
        combo.setQuantidadePessoas(2);
        assertEquals(55.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboFamiliaGrande() {
        Tamanho tamanho = new Grande();
        ComboFamilia combo = new ComboFamilia(25.0f);
        combo.setTamanho(tamanho);
        combo.setQuantidadePessoas(2);
        assertEquals(60.0f, combo.calcularValorFinal(), 0.01f);
    }

    @Test
    void deveRetornarValorComboFamiliaGigante() {
        Tamanho tamanho = new Gigante();
        ComboFamilia combo = new ComboFamilia(25.0f);
        combo.setTamanho(tamanho);
        combo.setQuantidadePessoas(2);
        assertEquals(65.0f, combo.calcularValorFinal(), 0.01f);
    }
}