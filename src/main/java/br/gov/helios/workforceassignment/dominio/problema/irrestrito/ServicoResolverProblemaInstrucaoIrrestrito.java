package br.gov.helios.workforceassignment.dominio.problema.irrestrito;

import static br.gov.helios.workforceassignment.dominio.problema.irrestrito.ProblemaInstrucaoIrrestritoOutput.formatarSolucao;

import br.gov.helios.workforceassignment.dominio.instrucao.FabricaInstrucoes;
import br.gov.helios.workforceassignment.dominio.instrucao.Instrucoes;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class ServicoResolverProblemaInstrucaoIrrestrito {
    public void resolver() throws Exception {
        IloCplex cplex = new IloCplex();

        /** Instancia dados do problema */

        Instrucoes repositorioInstrucoes = new FabricaInstrucoes().criar();

        /** Defini��o de vari�veis e fun��o objetivo */

        // Indica se a instru��o est� selecionada ou n�o
        IloNumVar[] instrucoes = cplex.boolVarArray(repositorioInstrucoes.quantidade());

        // Listagem dos pesos das instru��es
        int[] pesoInstrucoes = repositorioInstrucoes.pesos();

        // Fun��o objetivo
        IloLinearNumExpr objetivo = cplex.scalProd(pesoInstrucoes, instrucoes);
        cplex.addMaximize(objetivo);

        /** Defini��o de restri��es */

        // Carga hor�ria distribu�da deve ser menor que a total dispon�vel
        IloLinearNumExpr restricaoCarga = cplex.linearNumExpr();
        restricaoCarga.addTerms(repositorioInstrucoes.cargas(), instrucoes);
        cplex.addLe(restricaoCarga, repositorioInstrucoes.cargaMaxima());

        /** Solu��o */

        boolean resolvido = cplex.solve();
        formatarSolucao(cplex, resolvido, repositorioInstrucoes, instrucoes);
        cplex.end();
    }
}
