package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import Hamburgueria.interfaces.VisitorCardapio;

public class RelatorioCardapioVisitor implements VisitorCardapio {

    public String exibirHamburguer(Hamburguer hamburguer) {
        return "Hambúrguer: " + hamburguer.getNome()
                + " | Ingredientes: " + hamburguer.getIngredientes().size()
                + " | Preço: R$ " + hamburguer.getPreco();
    }

    public String exibirCombo(Combo combo) {
        return "Combo: " + combo.getNome()
                + " | Itens: " + combo.getItens().size()
                + " | Preço total: R$ " + combo.getPreco();
    }

    public String exibirIngrediente(Ingrediente ingrediente) {
        return "Ingrediente: " + ingrediente.getNome()
                + " | Tipo: " + ingrediente.getTipo();
    }

    public String exibirItem(ItemCardapio item) {
        if (item instanceof Hamburguer) {
            return ((Hamburguer) item).aceitar(this);
        }

        if (item instanceof Combo) {
            return ((Combo) item).aceitar(this);
        }

        return "Item não reconhecido";
    }
}