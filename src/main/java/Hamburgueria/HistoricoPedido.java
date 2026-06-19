package Hamburgueria;

import Hamburgueria.interfaces.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPedido {

    private List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public void executarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefa.executar();
    }

    public void cancelarUltimaTarefa() {
        if (!tarefas.isEmpty()) {
            Tarefa tarefa = tarefas.get(tarefas.size() - 1);
            tarefa.cancelar();
            tarefas.remove(tarefa);
        }
    }

    public int getQuantidadeTarefas() {
        return tarefas.size();
    }
}