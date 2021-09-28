package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victor.pederzini
 */
public class ConexaoMySqlDocker {

    private Connection connection;

    public Connection conectarAoDocker() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://172.17.0.2:3306/SmyDB";
            connection = DriverManager.getConnection(url, "Smy", "smy100");
            System.out.println("Conexão com MySQL no container estabelecida com sucesso!");
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("Erro ao conectar-se ao MySQL no container. Tente novamente mais tarde");
        }
        
        return connection;
        
    }

}
