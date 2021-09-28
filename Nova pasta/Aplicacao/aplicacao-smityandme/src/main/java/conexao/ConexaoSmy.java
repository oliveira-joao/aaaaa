/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class ConexaoSmy {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    private String connectionUrl = null;
    private Connection connection = null;

    public ConexaoSmy() {
        connectionUrl
                = "jdbc:sqlserver://bdprojeto2sem.database.windows.net:1433;"
                + "database=bdprojeto2sem;"
                + "user=smy;"
                + "password=#Gfgrupo4;"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";
    }

    public Connection conectar() {
        try {
            connection = DriverManager.getConnection(getConnectionUrl());
            System.out.println("Conexão com Azure estabelecida com sucesso!");

        } // Lida com todos os erros que podem ter ocorrido
        catch (SQLException e) {
            System.err.println("Erro ao conectar-se à Azure. Tente novamente mais tarde");
        }
        return connection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

}
