package br.gov.helios.workforceassignment.dominio.processo;

import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.COBRANCA_EXECUTIVA;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.DENUNCIA;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.MONITORAMENTO;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.PRESTACAO_CONTAS;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.RELATORIO_AUDITORIA;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.REPRESENTACAO;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.SOLICITACAO;
import static br.gov.helios.workforceassignment.dominio.processo.TipoProcesso.TOMADA_CONTAS_ESPECIAL;
import static br.gov.helios.workforceassignment.dominio.unidade.Unidade.SECEXADMIN;
import static br.gov.helios.workforceassignment.dominio.unidade.Unidade.SECEXAMB;
import static br.gov.helios.workforceassignment.dominio.unidade.Unidade.SECEXDEFES;
import static br.gov.helios.workforceassignment.dominio.unidade.Unidade.SECEXFAZEN;
import static br.gov.helios.workforceassignment.dominio.unidade.Unidade.SECEXPREVI;

import java.util.ArrayList;
import java.util.List;

import br.gov.helios.workforceassignment.dominio.unidade.Unidade;

public enum Processo {

    PROCESSO1(1, SECEXADMIN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO2(2, SECEXADMIN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO3(3, SECEXADMIN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO4(4, SECEXADMIN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO5(5, SECEXADMIN, REPRESENTACAO),
    PROCESSO6(6, SECEXADMIN, REPRESENTACAO),
    PROCESSO7(7, SECEXADMIN, MONITORAMENTO),
    PROCESSO8(8, SECEXADMIN, MONITORAMENTO),
    PROCESSO9(9, SECEXADMIN, SOLICITACAO),
    PROCESSO10(10, SECEXADMIN, DENUNCIA),

    PROCESSO11(11, SECEXAMB, TOMADA_CONTAS_ESPECIAL),
    PROCESSO12(12, SECEXAMB, TOMADA_CONTAS_ESPECIAL),
    PROCESSO13(13, SECEXAMB, TOMADA_CONTAS_ESPECIAL),
    PROCESSO14(14, SECEXAMB, REPRESENTACAO),
    PROCESSO15(15, SECEXAMB, REPRESENTACAO),
    PROCESSO16(16, SECEXAMB, REPRESENTACAO),
    PROCESSO17(17, SECEXAMB, RELATORIO_AUDITORIA),
    PROCESSO18(18, SECEXAMB, COBRANCA_EXECUTIVA),
    PROCESSO19(19, SECEXAMB, PRESTACAO_CONTAS),
    PROCESSO20(20, SECEXAMB, PRESTACAO_CONTAS),

    PROCESSO21(21, SECEXDEFES, TOMADA_CONTAS_ESPECIAL),
    PROCESSO22(22, SECEXDEFES, TOMADA_CONTAS_ESPECIAL),
    PROCESSO23(23, SECEXDEFES, PRESTACAO_CONTAS),
    PROCESSO24(24, SECEXDEFES, PRESTACAO_CONTAS),
    PROCESSO25(25, SECEXDEFES, PRESTACAO_CONTAS),
    PROCESSO26(26, SECEXDEFES, MONITORAMENTO),
    PROCESSO27(27, SECEXDEFES, MONITORAMENTO),
    PROCESSO28(28, SECEXDEFES, MONITORAMENTO),
    PROCESSO29(29, SECEXDEFES, MONITORAMENTO),
    PROCESSO30(30, SECEXDEFES, DENUNCIA),

    PROCESSO31(31, SECEXFAZEN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO32(32, SECEXFAZEN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO33(33, SECEXFAZEN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO34(34, SECEXFAZEN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO35(35, SECEXFAZEN, TOMADA_CONTAS_ESPECIAL),
    PROCESSO36(36, SECEXFAZEN, PRESTACAO_CONTAS),
    PROCESSO37(37, SECEXFAZEN, COBRANCA_EXECUTIVA),
    PROCESSO38(38, SECEXFAZEN, COBRANCA_EXECUTIVA),
    PROCESSO39(39, SECEXFAZEN, COBRANCA_EXECUTIVA),
    PROCESSO40(40, SECEXFAZEN, SOLICITACAO),

    PROCESSO41(41, SECEXPREVI, TOMADA_CONTAS_ESPECIAL),
    PROCESSO42(42, SECEXPREVI, TOMADA_CONTAS_ESPECIAL),
    PROCESSO43(43, SECEXPREVI, PRESTACAO_CONTAS),
    PROCESSO44(44, SECEXPREVI, PRESTACAO_CONTAS),
    PROCESSO45(45, SECEXPREVI, PRESTACAO_CONTAS),
    PROCESSO46(46, SECEXPREVI, PRESTACAO_CONTAS),
    PROCESSO47(47, SECEXPREVI, REPRESENTACAO),
    PROCESSO48(48, SECEXPREVI, REPRESENTACAO),
    PROCESSO49(49, SECEXPREVI, REPRESENTACAO),
    PROCESSO50(50, SECEXPREVI, COBRANCA_EXECUTIVA);

    public final long id;
    public final TipoProcesso tipo;
    public final Unidade unidade;

    Processo(long id, Unidade unidade, TipoProcesso tipo) {
        this.id = id;
        this.tipo = tipo;
        this.unidade = unidade;
    }

    public static int total() {
        return values().length;
    }

    public static int[] valorProcessos() {
        int[] valores = new int[total()];
        for (int i = 0; i < total(); i++) {
            valores[i] = processo(i).tipo.valor;
        }
        return valores;
    }

    public static Double cargaProcessualDaUnidade(Unidade unidade) {
        double carga = 0;
        for (int i = 0; i < total(); i++) {
            Processo processo = processo(i);
            if (processo.unidade == unidade) {
                carga += processo.tipo.carga;
            }
        }
        return carga;
    }

    public static int valorProcessualDaUnidade(Unidade unidade) {
        int valor = 0;
        for (int i = 0; i < total(); i++) {
            Processo processo = processo(i);
            if (processo.unidade == unidade) {
                valor += processo.tipo.valor;
            }
        }
        return valor;
    }

    public static double[] cargaProcessos() {
        double[] cargas = new double[total()];
        for (int i = 0; i < total(); i++) {
            cargas[i] = processo(i).tipo.carga;
        }
        return cargas;
    }

    public static List<Processo> processos(Unidade unidade) {
        List<Processo> processos = new ArrayList<>();
        for (Processo processo : values()) {
            if (processo.unidade == unidade) {
                processos.add(processo);
            }
        }
        return processos;
    }

    public static Processo processo(int index) {
        return values()[index];
    }
}
