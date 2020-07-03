package br.gov.helios.workforceassignment;

import br.gov.helios.workforceassignment.aplicacao.ServicoAplicacaoResolverProblemaAplicacao;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        boolean problemaComInstrucao = true;
        new ServicoAplicacaoResolverProblemaAplicacao().resolver(problemaComInstrucao);
    }
}
