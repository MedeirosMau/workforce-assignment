package br.gov.helios.workforceassignment.dominio.problema.irrestrito;

import static java.lang.Double.valueOf;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.helios.workforceassignment.dominio.instrucao.EstoqueInstrucao;
import br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao;
import br.gov.helios.workforceassignment.dominio.instrucao.Instrucao;
import br.gov.helios.workforceassignment.dominio.instrucao.Instrucoes;
import br.gov.helios.workforceassignment.dominio.instrucao.UnidadeInstrucao;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class ProblemaInstrucaoIrrestritoOutput {

    public static void formatarSolucao(IloCplex cplex, boolean resolvido, Instrucoes repositorioInstrucoes,
            IloNumVar[] instrucoesSelecionadas) throws Exception {
        if (resolvido) {
            cplex.output().println("\n\nSolution status = " + cplex.getStatus());
            cplex.output().println("Solution value = " + cplex.getObjValue());

            // Total de instruções

            cplex.output().println(format("\n# Total de instruções em estoque: %d", EstoqueInstrucao.totalInstrucoes()));

            // Exibe e agrupa processos selecionados por unidade

            Map<UnidadeInstrucao, List<Instrucao>> mapaInstrucoesSelecionadas = new HashMap<>();
            Map<UnidadeInstrucao, Double> mapaCargaUnidade = new HashMap<>();
            Map<GrupoTipoInstrucao, Double> mapaCargaGrupo = new HashMap<>();
            Map<UnidadeInstrucao, Integer> mapaPeso = new HashMap<>();

            double[] instrucoesSelecionadasValues = cplex.getValues(instrucoesSelecionadas);

            for (int j = 0; j < cplex.getNcols(); j++) {
                Instrucao instrucao = repositorioInstrucoes.get(j);

                // Adiciona processo na unidade

                List<Instrucao> instrucoesUnidade = mapaInstrucoesSelecionadas.get(instrucao.unidade);
                if (instrucoesUnidade == null) {
                    instrucoesUnidade = new ArrayList<>();
                    mapaInstrucoesSelecionadas.put(instrucao.unidade, instrucoesUnidade);
                }
                if (instrucoesSelecionadasValues[j] > 0) {
                    instrucoesUnidade.add(instrucao);

                    // Calcula carga atribuída para unidade

                    Double carga = mapaCargaUnidade.get(instrucao.unidade);
                    if (carga == null) {
                        carga = valueOf(0);
                    }
                    mapaCargaUnidade.put(instrucao.unidade, carga + instrucao.tipoInstrucao.carga);

                    // Calcula carga atribuída para grupo

                    Double cargaGrupo = mapaCargaGrupo.get(instrucao.grupoTipoInstrucao);
                    if (cargaGrupo == null) {
                        cargaGrupo = valueOf(0);
                    }
                    mapaCargaGrupo.put(instrucao.grupoTipoInstrucao, cargaGrupo + instrucao.tipoInstrucao.carga);

                    // Calcula valor processual por unidade

                    Integer valor = mapaPeso.get(instrucao.unidade);
                    if (valor == null) {
                        valor = 0;
                    }
                    mapaPeso.put(instrucao.unidade, valor + instrucao.tipoInstrucao.peso());
                }
            }

            cplex.output().println("\n--");

            // Exibe consolidado das unidades

            int cargaTotal = 0;
            int cargaEfetivada = 0;

            for (UnidadeInstrucao unidade : UnidadeInstrucao.values()) {
                cargaTotal += repositorioInstrucoes.cargaDaUnidade(unidade).intValue();
                cplex.output().println(format("\n# Unidade: %s", unidade.descricao));

                Double cargaUnidade = mapaCargaUnidade.get(unidade);

                if (cargaUnidade != null) {
                    cargaEfetivada += cargaUnidade;
                    cplex.output().println(
                            format(
                                    "- Carga processual atendida: %d/%d",
                                    mapaCargaUnidade.get(unidade).intValue(),
                                    repositorioInstrucoes.cargaDaUnidade(unidade).intValue()));
                    cplex.output().println(
                            format(
                                    "- Valor processual atendido: %d/%d",
                                    mapaPeso.get(unidade).intValue(),
                                    repositorioInstrucoes.pesoDaUnidade(unidade)));
                } else {
                    cplex.output().println(
                            format(
                                    "- Carga processual atendida: 0/%d",
                                    repositorioInstrucoes.cargaDaUnidade(unidade).intValue()));
                    cplex.output().println(
                            format(
                                    "- Valor processual atendido: 0/%d",
                                    repositorioInstrucoes.pesoDaUnidade(unidade)));
                }
            }

            cplex.output().println(format("\n# Carga efetivada: %d/%d", cargaEfetivada, cargaTotal));

            // Verifica atribuição por grupo

            for (GrupoTipoInstrucao grupo : GrupoTipoInstrucao.values()) {
                Double cargaAtribuida = mapaCargaGrupo.get(grupo);
                if (cargaAtribuida == null) {
                    cargaAtribuida = valueOf(0);
                }
                Double cargaEmEstoque = repositorioInstrucoes.cargaEmEstoqueDoGrupo(grupo);
                cplex.output().println(
                        format("# Carga do grupo %s: %d/%d", grupo.descricao, cargaAtribuida.intValue(),
                                cargaEmEstoque.intValue()));
            }

        } else {
            cplex.output().println("Não resolvido.");
        }
    }
}
