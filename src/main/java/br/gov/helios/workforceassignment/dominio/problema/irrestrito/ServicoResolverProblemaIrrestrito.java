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

        /** Defini��o de vari�veis e fun��o objetivo */

        // Indica se processo est� selecionado ou n�o
        IloNumVar[] processos = cplex.boolVarArray(Processo.total());

        // Listagem dos valores (peso) dos processos
        int[] valorProcessos = Processo.valorProcessos();

        // Fun��o objetivo
        IloLinearNumExpr objetivo = cplex.scalProd(valorProcessos, processos);
        cplex.addMaximize(objetivo);

        /** Defini��o de restri��es */

        // Carga hor�ria distribu�da deve ser menor que a total dispon�vel
        IloLinearNumExpr restricaoCarga = cplex.linearNumExpr();
        restricaoCarga.addTerms(Processo.cargaProcessos(), processos);
        cplex.addLe(restricaoCarga, CargaTrabalho.CARGA_MAXIMA);

        /** Solu��o */

        boolean resolvido = cplex.solve();
        formatarSolucao(cplex, resolvido, processos);
        cplex.end();
    }
}
