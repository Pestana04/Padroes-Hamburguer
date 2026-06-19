package Hamburgueria.interfaces;

import Hamburgueria.SetorHamburgueria;

public interface MediadorHamburgueria {

    void enviarMensagem(String mensagem, SetorHamburgueria origem);
}