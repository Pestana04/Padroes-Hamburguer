package Hamburgueria;

public class PreparoHamburguerTradicional extends PreparoHamburguer {

    protected String getNome() {
        return "X-Burguer Tradicional";
    }

    protected double getPreco() {
        return 20.0;
    }

    protected void adicionarPao(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Pão Tradicional", "Massa");
    }

    protected void adicionarProteina(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Carne Bovina", "Proteína");
    }

    protected void adicionarQueijo(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Queijo Mussarela", "Laticínio");
    }

    protected void adicionarMolho(HamburguerBuilder builder) {
        builder.adicionarIngrediente("Molho da Casa", "Molho");
    }
}