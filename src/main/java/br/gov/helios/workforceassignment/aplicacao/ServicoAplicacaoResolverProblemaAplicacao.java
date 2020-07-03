package br.gov.helios.workforceassignment.aplicacao;

import br.gov.helios.workforceassignment.dominio.problema.irrestrito.ServicoResolverProblemaInstrucaoIrrestrito;
import br.gov.helios.workforceassignment.dominio.problema.irrestrito.ServicoResolverProblemaIrrestrito;

public class ServicoAplicacaoResolverProblemaAplicacao {

    public void resolver(boolean problemaComInstrucao) {
        try {
            if (!problemaComInstrucao) {
                new ServicoResolverProblemaIrrestrito().resolver();
            } else {
                new ServicoResolverProblemaInstrucaoIrrestrito().resolver();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro no processamento do problema.", e);
        }
    }

}
