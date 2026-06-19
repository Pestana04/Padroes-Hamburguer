package Hamburgueria;

import java.util.Arrays;

public class Atendente extends Funcionario {

    public Atendente() {
        super(Arrays.asList(
                "Registrar Pedido",
                "Receber Pagamento"
        ));
    }

    public String getDescricaoCargo() {
        return "Atendente";
    }
}