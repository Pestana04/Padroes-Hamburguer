package Hamburgueria;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {

    private Funcionario superior;
    private List<String> solicitacoes = new ArrayList<String>();

    public Funcionario(List<String> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Funcionario getSuperior() {
        return superior;
    }

    public void setSuperior(Funcionario superior) {
        this.superior = superior;
    }

    public String atenderSolicitacao(String solicitacao) {
        if (solicitacoes.contains(solicitacao)) {
            return getDescricaoCargo() + " atendeu a solicitação: " + solicitacao;
        }

        if (superior != null) {
            return superior.atenderSolicitacao(solicitacao);
        }

        return "Solicitação não atendida: " + solicitacao;
    }

    public abstract String getDescricaoCargo();
}