package Hamburgueria;

public abstract class PreparoHamburguer {

    public final Hamburguer preparar() {
        HamburguerBuilder builder = new HamburguerBuilder();

        builder.setNome(getNome());
        builder.setPreco(getPreco());

        adicionarPao(builder);
        adicionarProteina(builder);
        adicionarQueijo(builder);
        adicionarMolho(builder);
        adicionarExtra(builder);

        return builder.build();
    }

    protected abstract String getNome();

    protected abstract double getPreco();

    protected abstract void adicionarPao(HamburguerBuilder builder);

    protected abstract void adicionarProteina(HamburguerBuilder builder);

    protected abstract void adicionarQueijo(HamburguerBuilder builder);

    protected abstract void adicionarMolho(HamburguerBuilder builder);

    protected void adicionarExtra(HamburguerBuilder builder) {
    }
}