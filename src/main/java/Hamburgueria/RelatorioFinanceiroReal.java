package Hamburgueria;

import Hamburgueria.interfaces.RelatorioFinanceiro;

import java.util.ArrayList;
import java.util.List;

public class RelatorioFinanceiroReal implements RelatorioFinanceiro {

    public List<String> gerarRelatorio(Funcionario funcionario) {
        List<String> relatorio = new ArrayList<String>();

        relatorio.add("Relatório financeiro da hamburgueria");
        relatorio.add("Total de pedidos: 25");
        relatorio.add("Faturamento total: R$ 1250.0");
        relatorio.add("Funcionário responsável: " + funcionario.getDescricaoCargo());

        return relatorio;
    }
}