package Hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class IngredienteFactory {

    private static Map<String, Ingrediente> ingredientes = new HashMap<String, Ingrediente>();

    public static Ingrediente getIngrediente(String nome, String tipo) {
        String chave = nome + "-" + tipo;

        Ingrediente ingrediente = ingredientes.get(chave);

        if (ingrediente == null) {
            ingrediente = new Ingrediente(nome, tipo);
            ingredientes.put(chave, ingrediente);
        }

        return ingrediente;
    }

    public static int getTotalIngredientes() {
        return ingredientes.size();
    }

    public static void limparIngredientes() {
        ingredientes.clear();
    }
}