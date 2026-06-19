package Hamburgueria;

import Hamburgueria.interfaces.MediadorHamburgueria;

public class CentralHamburgueria implements MediadorHamburgueria {

    private SetorHamburgueria atendimento;
    private SetorHamburgueria cozinha;
    private SetorHamburgueria gerencia;

    public void setAtendimento(SetorHamburgueria atendimento) {
        this.atendimento = atendimento;
    }

    public void setCozinha(SetorHamburgueria cozinha) {
        this.cozinha = cozinha;
    }

    public void setGerencia(SetorHamburgueria gerencia) {
        this.gerencia = gerencia;
    }

    public void enviarMensagem(String mensagem, SetorHamburgueria origem) {
        String mensagemFormatada = origem.getNomeSetor() + ": " + mensagem;

        if (atendimento != null && atendimento != origem) {
            atendimento.receberMensagem(mensagemFormatada);
        }

        if (cozinha != null && cozinha != origem) {
            cozinha.receberMensagem(mensagemFormatada);
        }

        if (gerencia != null && gerencia != origem) {
            gerencia.receberMensagem(mensagemFormatada);
        }
    }
}