package Hamburgueria;

import Hamburgueria.interfaces.ComboFactoryInterface;
import Hamburgueria.interfaces.ItemCardapio;

public class ComboPremiumFactory implements ComboFactoryInterface {

    public ItemCardapio criarHamburguer() {
        return new Hamburguer("X-Bacon Premium", 30.0);
    }

    public ItemCardapio criarAcompanhamento() {
        return new Hamburguer("Batata Grande", 12.0);
    }

    public ItemCardapio criarBebida() {
        return new Hamburguer("Milkshake", 15.0);
    }

    public Combo criarCombo() {
        Combo combo = new Combo("Combo Premium");

        combo.adicionarItem(criarHamburguer());
        combo.adicionarItem(criarAcompanhamento());
        combo.adicionarItem(criarBebida());

        return combo;
    }
}