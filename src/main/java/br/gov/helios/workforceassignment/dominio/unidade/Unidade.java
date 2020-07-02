package br.gov.helios.workforceassignment.dominio.unidade;

public enum Unidade {

    SECEXADMIN(199630, "Secretaria de Controle Externo da Administra��o do Estado"),
    SECEXAMB(199625, "Secretaria de Controle Externo da Agricultura e do Meio Ambiente"),
    SECEXDEFES(199583, "Secretaria de Controle Externo da Defesa Nacional e da Seguran�a P�blica"),
    // SECEXDESEN(199616, "Secretaria de Controle Externo do Desenvolvimento Econ�mico"),
    // SECEXEDUC(199600, "Secretaria de Controle Externo da Educa��o, da Cultura e do Desporto"),
    SECEXFAZEN(199620, "Secretaria de Controle Externo da Fazenda Nacional"),
    SECEXPREVI(199610, "Secretaria de Controle Externo da Previd�ncia e da Assist�ncia Social");
    // SECEXSAUDE(199605, "Secretaria de Controle Externo da Sa�de"),
    // SECEXTCE(199804, "Secretaria de Controle Externo de Tomada de Contas Especial"),
    // SELOG(199593, "Secretaria de Controle Externo de Aquisi��es Log�sticas");

    public final long id;
    public final String nome;

    Unidade(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
