package br.gov.helios.workforceassignment.dominio.instrucao;

import java.util.List;

public class Instrucoes {

    public final List<Instrucao> repositorio;

    public Instrucoes(List<Instrucao> repositorio) {
        this.repositorio = repositorio;
    }

    public int quantidade() {
        return repositorio.size();
    }

    public int[] pesos() {
        int[] pesos = new int[quantidade()];
        for (int i = 0; i < quantidade(); i++) {
            pesos[i] = repositorio.get(i).tipoInstrucao.peso();
        }
        return pesos;
    }

    public double[] cargas() {
        double[] cargas = new double[quantidade()];
        for (int i = 0; i < quantidade(); i++) {
            cargas[i] = repositorio.get(i).tipoInstrucao.carga;
        }
        return cargas;
    }

    public double cargaMaxima() {
        return 82675;
    }
}
