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

        /** Definição de variáveis e função objetivo */

        // Indica se a instrução está selecionada ou não
        IloNumVar[] instrucoes = cplex.boolVarArray(repositorioInstrucoes.quantidade());

        // Listagem dos pesos das instruções
        int[] pesoInstrucoes = repositorioInstrucoes.pesos();

        // Função objetivo
        IloLinearNumExpr objetivo = cplex.scalProd(pesoInstrucoes, instrucoes);
        cplex.addMaximize(objetivo);

        /** Definição de restrições */

        // Carga horária distribuída deve ser menor que a total disponível
        IloLinearNumExpr restricaoCarga = cplex.linearNumExpr();
        restricaoCarga.addTerms(repositorioInstrucoes.cargas(), instrucoes);
        cplex.addLe(restricaoCarga, repositorioInstrucoes.cargaMaxima());

        /** Solução */

        boolean resolvido = cplex.solve();
        formatarSolucao(cplex, resolvido, repositorioInstrucoes, instrucoes);
        cplex.end();
    }
}
