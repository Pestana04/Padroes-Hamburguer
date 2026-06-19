package Hamburgueria;

public class CalculadoraPrecoPedido {

    private String formula;

    public CalculadoraPrecoPedido() {
        this.formula = "valorPedido + taxaEntrega - desconto";
    }

    public CalculadoraPrecoPedido(String formula) {
        this.formula = formula;
    }

    public double calcular(double valorPedido, double taxaEntrega, double desconto) {
        String expressao = formula
                .replace("valorPedido", String.valueOf(valorPedido))
                .replace("taxaEntrega", String.valueOf(taxaEntrega))
                .replace("desconto", String.valueOf(desconto));

        return CalculadoraExpressao.calcular(expressao);
    }

    public String getFormula() {
        return formula;
    }
}