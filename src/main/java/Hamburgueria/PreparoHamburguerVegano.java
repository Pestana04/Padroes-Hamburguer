package Hamburgueria;

public class PreparoHamburguerVegano extends PreparoHamburguer {

    protected String getNome() {
        return "Hamburguer Vegano";
    }

    protected double getPreco() {
        return 25.0;
    }

    protected void adicionarPao(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Pão Integral", "Massa");
    }

    protected void adicionarProteina(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Hamburguer de Grão-de-Bico", "Proteína Vegetal");
    }

    protected void adicionarQueijo(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Queijo Vegano", "Vegetal");
    }

    protected void adicionarMolho(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Molho Verde", "Molho");
    }
}