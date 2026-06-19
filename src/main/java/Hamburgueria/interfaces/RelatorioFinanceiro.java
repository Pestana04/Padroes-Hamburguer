package Hamburgueria.interfaces;

import Hamburgueria.Funcionario;

import java.util.List;

public interface RelatorioFinanceiro {

    List<String> gerarRelatorio(Funcionario funcionario);
}