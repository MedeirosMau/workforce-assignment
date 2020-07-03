package br.gov.helios.workforceassignment.dominio.instrucao;

public enum UnidadeInstrucao {

    SECEXTCE(199804, "SecexTCE", "Secretaria de Controle Externo de Tomada de Contas Especial"),
    SECEXTRAB(199882, "SecexTrab", "Secretaria de Controle Externo do Trabalho e Entidades Paraestatais"),
    SEPROC(199883, "Seproc", "Secretaria de Gestão de Processos"),
    SEC_MA(199090, "Sec-MA", "Secretaria do TCU no Estado do Maranhão"),
    SEC_PE(199150, "Sec-PE", "Secretaria do TCU no Estado de Pernambuco"),
    SEC_TO(199260, "Sec-TO", "Secretaria do TCU no Estado de Tocantins"),
    SEINFRACOM(199680, "SeinfraCOM", "Secretaria de Infraestrutura Hídrica, de Comunicações e de Mineração"),
    SEINFRAPET(199686, "SeinfraPet", "Secretaria de Fiscalização de Infraestrutura de Petróleo e Gás Natural"),
    SEINFRAELE(199691, "SeinfraEle", "Secretaria de Fiscalização de Infraestrutura de Energia Elétrica"),
    SEINFRAPOR(199695, "SeinfraPor", "Secretaria de Fiscalização de Infraestrutura Portuária e Ferroviária"),
    SEINFRAROD(199702, "SeinfraRod", "Secretaria de Fiscalização de Infraestrutura Rodoviária e de Aviação Civil"),
    SEINFRAURB(199709, "SeinfraUrb", "Secretaria de Fiscalização de Infraestrutura Urbana"),
    SEMEC(199722, "Semec", "Secretaria de Métodos e Suporte ao Controle Externo"),
    SEINFRAOPE(199754, "SeinfraOpe", "Secretaria Extraordinária de Operações Especiais em Infraestrutura"),
    SEC_ES(199070, "Sec-ES", "Secretaria do TCU no Estado do Espírito Santo"),
    SEC_RO(199210, "Sec-RO", "Secretaria do TCU no Estado de Rondônia"),
    SECEX_2(191800, "SECEX-2", "2ª Secretaria de Controle Externo"),
    SEC_AC(199010, "Sec-AC", "Secretaria do TCU no Estado do Acre"),
    SECEXADMIN(199630, "SecexAdmin", "Secretaria de Controle Externo da Administração do Estado"),
    SECEXPREVI(199610, "SecexPrevi", "Secretaria de Controle Externo da Gestão Tributária, da Previdência e Assistência Social"),
    SEC_RS(199200, "Sec-RS", "Secretaria do TCU no Estado do Rio Grande do Sul"),
    SECEX_8(199474, "SECEX-8", "8ª Secretaria de Controle Externo"),
    SECEXESTAT(199475, "SecexEstat", "Secretaria de Controle Externo da Administração Indireta no Rio de Janeiro"),
    SEFTI(199400, "SEFTI", "Secretaria de Fiscalização de Tecnologia da Informação"),
    SECEXDEFES(199583, "SecexDefes", "Secretaria de Controle Externo da Defesa Nacional e da Segurança Pública"),
    SELOG(199593, "Selog", "Secretaria de Controle Externo de Aquisições Logísticas"),
    SECEXEDUC(199600, "SecexEduc", "Secretaria de Controle Externo da Educação"),
    SECEXSAUDE(199605, "SecexSaude", "Secretaria de Controle Externo da Saúde"),
    SECEXDESEN(199616, "SecexDesen", "Secretaria de Controle Externo do Desenvolvimento Econômico"),
    SECEXFINAN(199620, "SecexFinan", "Secretaria de Controle Externo do Sistema Financeiro Nacional e dos Fundos de Pensão"),
    SECEXAMB(199625, "SecexAmb", "Secretaria de Controle Externo da Agricultura e do Meio Ambiente"),
    SEMAG(190300, "SEMAG", "Secretaria de Macroavaliação Governamental"),
    SEFIP(191200, "SEFIP", "Secretaria de Fiscalização de Pessoal"),
    SECEX_4(191400, "SECEX-4", "4ª Secretaria de Controle Externo"),
    SECEX_5(191500, "SECEX-5", "5ª Secretaria de Controle Externo"),
    SECEX_6(191600, "SECEX-6", "6ª Secretaria de Controle Externo"),
    SERUR(192000, "SERUR", "Secretaria de Recursos"),
    SEC_AL(199020, "Sec-AL", "Secretaria do TCU no Estado de Alagoas"),
    SEC_AM(199030, "Sec-AM", "Secretaria do TCU no Estado do Amazonas"),
    SEC_AP(199040, "Sec-AP", "Secretaria do TCU no Estado do Amapá"),
    SEC_BA(199050, "Sec-BA", "Secretaria do TCU no Estado da Bahia"),
    SEC_CE(199060, "Sec-CE", "Secretaria do TCU no Estado do Ceará"),
    SEC_GO(199080, "Sec-GO", "Secretaria do TCU no Estado de Goiás"),
    SEC_MG(199100, "Sec-MG", "Secretaria do TCU no Estado de Minas Gerais"),
    SEC_MT(199120, "Sec-MT", "Secretaria do TCU no Estado de Mato Grosso"),
    SEC_PA(199130, "Sec-PA", "Secretaria do TCU no Estado do Pará"),
    SEC_PB(199140, "Sec-PB", "Secretaria do TCU no Estado da Paraíba"),
    SEC_PI(199160, "Sec-PI", "Secretaria do TCU no Estado do Piauí"),
    SEC_PR(199170, "Sec-PR", "Secretaria do TCU no Estado do Paraná"),
    SEC_RJ(199180, "Sec-RJ", "Secretaria do TCU no Estado do Rio de Janeiro"),
    SEC_RN(199190, "Sec-RN", "Secretaria do TCU no Estado do Rio Grande do Norte"),
    SEC_RR(199220, "Sec-RR", "Secretaria do TCU no Estado de Roraima"),
    SEC_SC(199230, "Sec-SC", "Secretaria do TCU no Estado de Santa Catarina"),
    SEC_SE(199240, "Sec-SE", "Secretaria do TCU no Estado de Sergipe"),
    SEC_SP(199250, "Sec-SP", "Secretaria do TCU no Estado de São Paulo");

    public final int id;
    public final String sigla;
    public final String descricao;

    UnidadeInstrucao(int id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }

}
