package Hamburgueria;

import java.util.Arrays;

public class Cozinha extends Funcionario {

    public Cozinha() {
        super(Arrays.asList(
                "Preparar Pedido",
                "Finalizar Preparo"
        ));
    }

    public String getDescricaoCargo() {
        return "Cozinha";
    }
}