package br.gov.helios.workforceassignment.dominio.processo;

import static java.lang.String.format;

public enum TipoProcesso {

    TOMADA_CONTAS_ESPECIAL(50, "TOMADA DE CONTAS ESPECIAL", "TCE", 100, 500),
    REPRESENTACAO(41, "REPRESENTA��O", "REPR", 40, 30),
    PRESTACAO_CONTAS(34, "PRESTA��O DE CONTAS", "PC", 70, 50),
    MONITORAMENTO(98, "MONITORAMENTO", "MON", 15, 20),
    COBRANCA_EXECUTIVA(25, "COBRAN�A EXECUTIVA", "CBEX", 10, 20),
    RELATORIO_AUDITORIA(39, "RELAT�RIO DE AUDITORIA", "RA", 10, 20),
    SOLICITACAO(48, "SOLICITA��O", "SOLI", 5, 10),
    DENUNCIA(30, "DEN�NCIA", "DEN", 10, 20);

    public final int id;
    public final String descricao;
    public final String sigla;
    public final double carga;
    public final int valor;

    TipoProcesso(int id, String descricao, String sigla, double carga, int valor) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
        this.carga = carga;
        this.valor = valor;
    }

    public static TipoProcesso obter(int id) {
        for (TipoProcesso tipo : TipoProcesso.values()) {
            if (tipo.id == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException(format("Tipo de processo inv�lido (%d)", id));
    }
}
