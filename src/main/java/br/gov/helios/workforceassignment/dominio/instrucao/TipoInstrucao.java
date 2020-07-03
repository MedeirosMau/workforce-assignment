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

    AJSOL("AJSOL", "A��ES JUDICIAIS_SOLICITA��O DE SUBS�DIOS", OUTROS_CONTROLE_EXTERNO, 3),
    SCN("SCN", "SOLICITA��O DO CONGRESSO NACIONAL", SOLICITACAO_CN, 12),
    SCT("SCT", "SOLICITA��O DE CERTID�O", OUTROS_CONTROLE_EXTERNO, 2),
    CGOV("CGOV", "CONTAS DO PRESIDENTE DA REP�BLICA", CONTAS, 1),
    TCSP("TCSP", "TOMADA DE CONTAS SIMPLIFICADA", CONTAS, 4),
    RACOM("RACOM", "RELAT�RIO DE ACOMPANHAMENTO", FISCALIZACAO, 16),
    SOLI("SOLI", "SOLICITA��O", OUTROS_CONTROLE_EXTERNO, 3),
    TCE("TCE", "TOMADA DE CONTAS ESPECIAL", TCEG, 6),
    RA("RA", "RELAT�RIO DE AUDITORIA", FISCALIZACAO, 15),
    RL("RL", "RELAT�RIO DE LEVANTAMENTO", FISCALIZACAO, 17),
    IND("IND", "INDISPONIBILIDADE DE BENS", OUTROS_CONTROLE_EXTERNO, 14),
    APOS("APOS", "APOSENTADORIA", PESSOAL, 3),
    REPR("REPR", "REPRESENTA��O", DRC, 9),
    PEEC("PEEC", "PENS�O ESPECIAL DE EX-COMBATENTE", PESSOAL, 4),
    TC("TC", "TOMADA DE CONTAS", CONTAS, 9),
    PCIV("PCIV", "PENS�O CIVIL", PESSOAL, 3),
    DEN("DEN", "DEN�NCIA", DRC, 9),
    RMON("RMON", "RELAT�RIO DE MONITORAMENTO", FISCALIZACAO, 19),
    REFO("REFO", "REFORMA", PESSOAL, 3),
    ACOM("ACOM", "ACOMPANHAMENTO", OUTROS_CONTROLE_EXTERNO, 12),
    MON("MON", "MONITORAMENTO", OUTROS_CONTROLE_EXTERNO, 13),
    DES("DES", "DESESTATIZA��O", DESG, 14),
    ADM("ADM", "ADMINISTRATIVO", ADMINISTRATIVO, 2),
    CCTO("CCTO", "CONTESTA��O DE COEFICIENTES DE TRANSF.OBRIGAT�RIAS", OUTROS_CONTROLE_EXTERNO, 2),
    PCSP("PCSP", "PRESTA��O DE CONTAS SIMPLIFICADA", CONTAS, 11),
    ADS("ADS", "ATOS DE ADMISS�O", PESSOAL, 4),
    PMIL("PMIL", "PENS�O MILITAR", PESSOAL, 3),
    PCEX("PCEX", "PRESTA��O DE CONTAS EXTRAORDIN�RIA", CONTAS, 26),
    PC("PC", "PRESTA��O DE CONTAS", CONTAS, 17),
    RI("RI", "RELAT�RIO DE INSPE��O", FISCALIZACAO, 14),
    MSPI("MSPI", "MANDADO DE SEGURAN�A_PRESTA��O DE INFORMA��ES", OUTROS_CONTROLE_EXTERNO, 2),
    CONS("CONS", "CONSULTA", DRC, 9),
    CBEX("CBEX", "COBRAN�A EXECUTIVA", CBEXG, 6);

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
