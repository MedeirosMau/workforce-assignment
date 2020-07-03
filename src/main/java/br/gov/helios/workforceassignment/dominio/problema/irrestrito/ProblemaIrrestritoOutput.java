package br.gov.helios.workforceassignment.dominio.problema.irrestrito;

import static br.gov.helios.workforceassignment.dominio.processo.Processo.cargaProcessualDaUnidade;
import static br.gov.helios.workforceassignment.dominio.processo.Processo.valorProcessualDaUnidade;
import static java.lang.Double.valueOf;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.helios.workforceassignment.dominio.processo.Processo;
import br.gov.helios.workforceassignment.dominio.unidade.Unidade;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class ProblemaIrrestritoOutput {

    public static void formatarSolucao(IloCplex cplex, boolean resolvido, IloNumVar[] processosSelecionados) throws Exception {
        if (resolvido) {
            cplex.output().println("\n\nSolution status = " + cplex.getStatus());
            cplex.output().println("Solution value = " + cplex.getObjValue());

            // Exibe e agrupa processos selecionados por unidade

            Map<Unidade, List<Processo>> mapaProcessosSelecionados = new HashMap<>();
            Map<Unidade, Double> mapaCarga = new HashMap<>();
            Map<Unidade, Integer> mapaValor = new HashMap<>();

            double[] processosSelecionadosValues = cplex.getValues(processosSelecionados);

            for (int j = 0; j < cplex.getNcols(); j++) {
                Processo processo = Processo.processo(j);

                // Adiciona processo na unidade

                List<Processo> processosUnidade = mapaProcessosSelecionados.get(processo.unidade);
                if (processosUnidade == null) {
                    processosUnidade = new ArrayList<>();
                    mapaProcessosSelecionados.put(processo.unidade, processosUnidade);
                }
                if (processosSelecionadosValues[j] > 0) {
                    processosUnidade.add(processo);

                    // Calcula carga atribuída para unidade

                    Double carga = mapaCarga.get(processo.unidade);
                    if (carga == null) {
                        carga = valueOf(0);
                    }
                    mapaCarga.put(processo.unidade, carga + processo.tipo.carga);

                    // Calcula valor processual por unidade

                    Integer valor = mapaValor.get(processo.unidade);
                    if (valor == null) {
                        valor = 0;
                    }
                    mapaValor.put(processo.unidade, valor + processo.tipo.valor);
                }
            }

            cplex.output().println("\n--");

            // Exibe consolidado das unidades

            for (Unidade unidade : Unidade.values()) {
                cplex.output().println(format("\n# Unidade: %s", unidade.nome));
                cplex.output().println(
                        format(
                                "- Carga processual atendida: %d/%d",
                                mapaCarga.get(unidade).intValue(),
                                cargaProcessualDaUnidade(unidade).intValue()));
                cplex.output().println(
                        format(
                                "- Valor processual atendido: %d/%d",
                                mapaValor.get(unidade).intValue(),
                                valorProcessualDaUnidade(unidade)));
            }

            // Exibe processos selecionados de cada unidade

            for (Unidade unidade : Unidade.values()) {
                cplex.output().println(
                        format("\n# Unidade: %s\n", unidade.nome));
                List<Processo> todosProcessosUnidade = Processo.processos(unidade);
                List<Processo> processosUnidadeSelecionados = mapaProcessosSelecionados.get(unidade);
                for (Processo processo : todosProcessosUnidade) {
                    boolean foiSelecionado = processosUnidadeSelecionados.contains(processo);
                    cplex.output().println(
                            format("\t%s (%s) : %s",
                                    processo.name(),
                                    processo.tipo.descricao,
                                    foiSelecionado ? "Sim" : "Não"));
                }
            }
        } else {
            cplex.output().println("Não resolvido.");
        }
    }
}
