package Hamburgueria.interfaces;

import Hamburgueria.Combo;
import Hamburgueria.Hamburguer;
import Hamburgueria.Ingrediente;

public interface VisitorCardapio {

    String exibirHamburguer(Hamburguer hamburguer);

    String exibirCombo(Combo combo);

    String exibirIngrediente(Ingrediente ingrediente);
}