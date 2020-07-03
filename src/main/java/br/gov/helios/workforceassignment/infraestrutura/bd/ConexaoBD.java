package br.gov.helios.workforceassignment.infraestrutura.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    public static void conexao() {
        String usuario = "U_FERNANDESM";
        String senha = "852456";
        String url = "jdbc:oracle:thin:@srv-bd-labe-1a:1521:labetcu";
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
