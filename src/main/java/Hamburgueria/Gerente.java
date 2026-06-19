package Hamburgueria;

import java.util.Arrays;

public class Gerente extends Funcionario {

    public Gerente() {
        super(Arrays.asList(
                "Cancelar Pedido",
                "Resolver Reclamação",
                "Gerar Relatório Financeiro"
        ));
    }

    public String getDescricaoCargo() {
        return "Gerente";
    }
}