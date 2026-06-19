package Hamburgueria;

import Hamburgueria.interfaces.ComboFactoryInterface;
import Hamburgueria.interfaces.ItemCardapio;

public class ComboTradicionalFactory implements ComboFactoryInterface {

    public ItemCardapio criarHamburguer() {
        PreparoHamburguer preparo = new PreparoHamburguerTradicional();
        return preparo.preparar();
    }

    public ItemCardapio criarAcompanhamento() {
        return new Hamburguer("Batata Pequena", 8.0);
    }

    public ItemCardapio criarBebida() {
        return new Hamburguer("Refrigerante Lata", 6.0);
    }

    public Combo criarCombo() {
        Combo combo = new Combo("Combo Tradicional");

        combo.adicionarItem(criarHamburguer());
        combo.adicionarItem(criarAcompanhamento());
        combo.adicionarItem(criarBebida());

        return combo;
    }
}