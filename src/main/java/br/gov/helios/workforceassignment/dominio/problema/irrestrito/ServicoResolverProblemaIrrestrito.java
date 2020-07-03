package br.gov.helios.workforceassignment.dominio.problema.irrestrito;

import static br.gov.helios.workforceassignment.dominio.problema.irrestrito.ProblemaIrrestritoOutput.formatarSolucao;

import br.gov.helios.workforceassignment.dominio.processo.Processo;
import br.gov.helios.workforceassignment.dominio.trabalho.CargaTrabalho;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class ServicoResolverProblemaIrrestrito {

    public void resolver() throws Exception {
        IloCplex cplex = new IloCplex();

        /** Definição de variáveis e função objetivo */

        // Indica se processo está selecionado ou não
        IloNumVar[] processos = cplex.boolVarArray(Processo.total());

        // Listagem dos valores (peso) dos processos
        int[] valorProcessos = Processo.valorProcessos();

        // Função objetivo
        IloLinearNumExpr objetivo = cplex.scalProd(valorProcessos, processos);
        cplex.addMaximize(objetivo);

        /** Definição de restrições */

        // Carga horária distribuída deve ser menor que a total disponível
        IloLinearNumExpr restricaoCarga = cplex.linearNumExpr();
        restricaoCarga.addTerms(Processo.cargaProcessos(), processos);
        cplex.addLe(restricaoCarga, CargaTrabalho.CARGA_MAXIMA);

        /** Solução */

        boolean resolvido = cplex.solve();
        formatarSolucao(cplex, resolvido, processos);
        cplex.end();
    }
}
