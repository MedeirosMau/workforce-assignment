package br.gov.helios.workforceassignment.dominio.instrucao;

public class Instrucao {

    public final int id;
    public final TipoInstrucao tipoInstrucao;
    public final GrupoTipoInstrucao grupoTipoInstrucao;
    public final UnidadeInstrucao unidade;

    public Instrucao(int id, TipoInstrucao tipoInstrucao, GrupoTipoInstrucao grupoTipoInstrucao, UnidadeInstrucao unidade) {
        this.id = id;
        this.tipoInstrucao = tipoInstrucao;
        this.grupoTipoInstrucao = grupoTipoInstrucao;
        this.unidade = unidade;
    }

}
