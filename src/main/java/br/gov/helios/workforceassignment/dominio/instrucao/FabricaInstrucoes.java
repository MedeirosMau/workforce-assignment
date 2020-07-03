package br.gov.helios.workforceassignment.dominio.instrucao;

import java.util.ArrayList;
import java.util.List;

public class FabricaInstrucoes {

    public Instrucoes criar() {
        List<Instrucao> instrucoes = new ArrayList<>();
        for (EstoqueInstrucao estoque : EstoqueInstrucao.values()) {
            for (int i = 0; i < estoque.quantidade; i++) {
                Instrucao instrucao =
                        new Instrucao(
                                instrucoes.size() + 1,
                                estoque.tipoInstrucao,
                                estoque.tipoInstrucao.grupoTipoInstrucao,
                                estoque.unidade);
                instrucoes.add(instrucao);
            }
        }
        return new Instrucoes(instrucoes);
    }
}
