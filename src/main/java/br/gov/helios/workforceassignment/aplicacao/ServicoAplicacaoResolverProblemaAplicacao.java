package br.gov.helios.workforceassignment.aplicacao;

import br.gov.helios.workforceassignment.dominio.problema.irrestrito.ServicoResolverProblemaInstrucaoIrrestrito;

public class ServicoAplicacaoResolverProblemaAplicacao {

    public void resolver() {
        try {
            // new ServicoResolverProblemaIrrestrito().resolver();
            new ServicoResolverProblemaInstrucaoIrrestrito().resolver();
        } catch (Exception e) {
            throw new RuntimeException("Erro no processamento do problema.", e);
        }
    }

}
