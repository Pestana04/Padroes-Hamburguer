package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

import java.util.HashMap;
import java.util.Map;

public class CardapioPrototypeFactory {

    private static Map<String, ItemCardapio> modelos = new HashMap<String, ItemCardapio>();

    public static void adicionarModelo(String chave, ItemCardapio item) {
        modelos.put(chave, item);
    }

    public static ItemCardapio clonarModelo(String chave) {
        ItemCardapio item = modelos.get(chave);

        if (item instanceof Hamburguer) {
            return ((Hamburguer) item).clone();
        }

        if (item instanceof Combo) {
            return ((Combo) item).clone();
        }

        throw new IllegalArgumentException("Modelo não encontrado");
    }

    public static int getQuantidadeModelos() {
        return modelos.size();
    }

    public static void limparModelos() {
        modelos.clear();
    }
}