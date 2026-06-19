package Hamburgueria;

public class PreparoHamburguerPremium extends PreparoHamburguer {

    protected String getNome() {
        return "X-Bacon Premium";
    }

    protected double getPreco() {
        return 30.0;
    }

    protected void adicionarPao(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Pão Brioche", "Massa");
    }

    protected void adicionarProteina(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Carne Angus", "Proteína");
    }

    protected void adicionarQueijo(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Queijo Cheddar", "Laticínio");
    }

    protected void adicionarMolho(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Molho Especial", "Molho");
    }

    protected void adicionarExtra(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Bacon", "Proteína");
    }
}