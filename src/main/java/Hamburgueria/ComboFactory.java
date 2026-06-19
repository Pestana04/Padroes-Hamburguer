package Hamburgueria;

import Hamburgueria.interfaces.ComboFactoryInterface;

public class ComboFactory {

    public Combo criarComboTradicional() {
        ComboFactoryInterface factory = new ComboTradicionalFactory();
        return factory.criarCombo();
    }

    public Combo criarComboPremium() {
        ComboFactoryInterface factory = new ComboPremiumFactory();
        return factory.criarCombo();
    }
}