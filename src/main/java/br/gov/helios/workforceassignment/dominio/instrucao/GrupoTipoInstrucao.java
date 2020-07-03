package br.gov.helios.workforceassignment.dominio.instrucao;

public enum GrupoTipoInstrucao {

    ADMINISTRATIVO("ADMINISTRATIVO", 1),
    CBEXG("CBEX", 1),
    CONTAS("CONTAS", 1),
    DESG("DES", 1),
    DRC("DRC", 1),
    FISCALIZACAO("FISCALIZACAO", 2),
    OUTROS_CONTROLE_EXTERNO("OUTROS CONTROLE EXTERNO", 1),
    PESSOAL("PESSOAL", 1),
    SOLICITACAO_CN("SOLICITACAO CN", 1),
    TCEG("TCE", 2);

    public final String descricao;
    public final int peso;

    GrupoTipoInstrucao(String descricao, int peso) {
        this.descricao = descricao;
        this.peso = peso;
    }
}
