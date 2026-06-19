package Hamburgueria.interfaces;

import Hamburgueria.Combo;

public interface ComboFactoryInterface {

    ItemCardapio criarHamburguer();

    ItemCardapio criarAcompanhamento();

    ItemCardapio criarBebida();

    Combo criarCombo();
}