package br.gov.helios.workforceassignment.dominio.unidade;

public enum Unidade {

    SECEXADMIN(199630, "Secretaria de Controle Externo da Administração do Estado"),
    SECEXAMB(199625, "Secretaria de Controle Externo da Agricultura e do Meio Ambiente"),
    SECEXDEFES(199583, "Secretaria de Controle Externo da Defesa Nacional e da Segurança Pública"),
    // SECEXDESEN(199616, "Secretaria de Controle Externo do Desenvolvimento Econômico"),
    // SECEXEDUC(199600, "Secretaria de Controle Externo da Educação, da Cultura e do Desporto"),
    SECEXFAZEN(199620, "Secretaria de Controle Externo da Fazenda Nacional"),
    SECEXPREVI(199610, "Secretaria de Controle Externo da Previdência e da Assistência Social");
    // SECEXSAUDE(199605, "Secretaria de Controle Externo da Saúde"),
    // SECEXTCE(199804, "Secretaria de Controle Externo de Tomada de Contas Especial"),
    // SELOG(199593, "Secretaria de Controle Externo de Aquisições Logísticas");

    public final long id;
    public final String nome;

    Unidade(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
