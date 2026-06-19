package Hamburgueria;

import Hamburgueria.interfaces.RelatorioFinanceiro;

import java.util.List;

public class RelatorioFinanceiroProxy implements RelatorioFinanceiro {

    private RelatorioFinanceiroReal relatorioFinanceiroReal;

    public RelatorioFinanceiroProxy() {
        this.relatorioFinanceiroReal = new RelatorioFinanceiroReal();
    }

    public List<String> gerarRelatorio(Funcionario funcionario) {
        if (funcionario instanceof Gerente) {
            return relatorioFinanceiroReal.gerarRelatorio(funcionario);
        }

        throw new IllegalArgumentException("Funcionário não autorizado");
    }
}