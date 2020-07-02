package br.gov.helios.workforceassignment.aplicacao;

import br.gov.helios.workforceassignment.dominio.problema.cargaminimaunidade.ServicoResolverProblemaCargaMinimaUnidade;
import br.gov.helios.workforceassignment.dominio.problema.irrestrito.ServicoResolverProblemaIrrestrito;

public class ServicoAplicacaoResolverProblemaAplicacao {

    public void resolver(boolean problemaBasico) {
        try {
            if (problemaBasico) {
                new ServicoResolverProblemaIrrestrito().resolver();
            } else {
                new ServicoResolverProblemaCargaMinimaUnidade().resolver();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro no processamento do problema.", e);
        }
    }

}
