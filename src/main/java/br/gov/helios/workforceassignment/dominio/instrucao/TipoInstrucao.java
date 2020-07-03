package br.gov.helios.workforceassignment.dominio.instrucao;

import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.ADMINISTRATIVO;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.CBEXG;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.CONTAS;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.DESG;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.DRC;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.FISCALIZACAO;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.OUTROS_CONTROLE_EXTERNO;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.PESSOAL;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.SOLICITACAO_CN;
import static br.gov.helios.workforceassignment.dominio.instrucao.GrupoTipoInstrucao.TCEG;

public enum TipoInstrucao {

    AJSOL("AJSOL", "AÇÕES JUDICIAIS_SOLICITAÇÃO DE SUBSÍDIOS", OUTROS_CONTROLE_EXTERNO, 3),
    SCN("SCN", "SOLICITAÇÃO DO CONGRESSO NACIONAL", SOLICITACAO_CN, 12),
    SCT("SCT", "SOLICITAÇÃO DE CERTIDÃO", OUTROS_CONTROLE_EXTERNO, 2),
    CGOV("CGOV", "CONTAS DO PRESIDENTE DA REPÚBLICA", CONTAS, 1),
    TCSP("TCSP", "TOMADA DE CONTAS SIMPLIFICADA", CONTAS, 4),
    RACOM("RACOM", "RELATÓRIO DE ACOMPANHAMENTO", FISCALIZACAO, 16),
    SOLI("SOLI", "SOLICITAÇÃO", OUTROS_CONTROLE_EXTERNO, 3),
    TCE("TCE", "TOMADA DE CONTAS ESPECIAL", TCEG, 6),
    RA("RA", "RELATÓRIO DE AUDITORIA", FISCALIZACAO, 15),
    RL("RL", "RELATÓRIO DE LEVANTAMENTO", FISCALIZACAO, 17),
    IND("IND", "INDISPONIBILIDADE DE BENS", OUTROS_CONTROLE_EXTERNO, 14),
    APOS("APOS", "APOSENTADORIA", PESSOAL, 3),
    REPR("REPR", "REPRESENTAÇÃO", DRC, 9),
    PEEC("PEEC", "PENSÃO ESPECIAL DE EX-COMBATENTE", PESSOAL, 4),
    TC("TC", "TOMADA DE CONTAS", CONTAS, 9),
    PCIV("PCIV", "PENSÃO CIVIL", PESSOAL, 3),
    DEN("DEN", "DENÚNCIA", DRC, 9),
    RMON("RMON", "RELATÓRIO DE MONITORAMENTO", FISCALIZACAO, 19),
    REFO("REFO", "REFORMA", PESSOAL, 3),
    ACOM("ACOM", "ACOMPANHAMENTO", OUTROS_CONTROLE_EXTERNO, 12),
    MON("MON", "MONITORAMENTO", OUTROS_CONTROLE_EXTERNO, 13),
    DES("DES", "DESESTATIZAÇÃO", DESG, 14),
    ADM("ADM", "ADMINISTRATIVO", ADMINISTRATIVO, 2),
    CCTO("CCTO", "CONTESTAÇÃO DE COEFICIENTES DE TRANSF.OBRIGATÓRIAS", OUTROS_CONTROLE_EXTERNO, 2),
    PCSP("PCSP", "PRESTAÇÃO DE CONTAS SIMPLIFICADA", CONTAS, 11),
    ADS("ADS", "ATOS DE ADMISSÃO", PESSOAL, 4),
    PMIL("PMIL", "PENSÃO MILITAR", PESSOAL, 3),
    PCEX("PCEX", "PRESTAÇÃO DE CONTAS EXTRAORDINÁRIA", CONTAS, 26),
    PC("PC", "PRESTAÇÃO DE CONTAS", CONTAS, 17),
    RI("RI", "RELATÓRIO DE INSPEÇÃO", FISCALIZACAO, 14),
    MSPI("MSPI", "MANDADO DE SEGURANÇA_PRESTAÇÃO DE INFORMAÇÕES", OUTROS_CONTROLE_EXTERNO, 2),
    CONS("CONS", "CONSULTA", DRC, 9),
    CBEX("CBEX", "COBRANÇA EXECUTIVA", CBEXG, 6);

    public final String sigla;
    public final String descricao;
    public final GrupoTipoInstrucao grupoTipoInstrucao;
    public final int carga;

    TipoInstrucao(String sigla, String descricao, GrupoTipoInstrucao grupoTipoInstrucao, int carga) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.grupoTipoInstrucao = grupoTipoInstrucao;
        this.carga = carga;
    }

    public int peso() {
        return grupoTipoInstrucao.peso;
    }
}
