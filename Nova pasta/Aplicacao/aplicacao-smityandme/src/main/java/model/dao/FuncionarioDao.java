package model.dao;

import conexao.ConexaoSmy;
import dominios.Funcionario;
import funcionamento.sistema.GeradorDeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class FuncionarioDao {

    private ConexaoSmy conexao = new ConexaoSmy();
    private Connection con = conexao.conectar();
    private PreparedStatement pstm = null;
    private ResultSet resultadoQuery = null;
    private GeradorDeLog geradorDeLog = new GeradorDeLog();

    public Funcionario buscarDados(Funcionario usuarioQuerendoLogar) {
        Funcionario usuario = usuarioQuerendoLogar;

        try {
            String queryEmail = "SELECT * FROM funcionario WHERE emailFuncionario = ?";
            pstm = con.prepareStatement(queryEmail);
            // O setString vai pegar como parâmetro os ? que você coloca na query
            // e vai definir o valor dela no segundo parâmetro. Se eu tivesse
            // colocado dois ??, teria que fazer o setString(1, valor) e setString(2, valor)
            pstm.setString(1, usuario.getEmailFuncionario());
            resultadoQuery = pstm.executeQuery();

            while (resultadoQuery.next()) {
                usuario.setIdFuncionario(resultadoQuery.getInt("idFuncionario"));
                usuario.setNomeFuncionario(resultadoQuery.getString("nomeFuncionario"));
                usuario.setLoginFuncionario(resultadoQuery.getString("loginFuncionario"));
                usuario.setSenhaFuncionario(resultadoQuery.getString("senhaFuncionario"));
                usuario.setEmailFuncionario(resultadoQuery.getString("emailFuncionario"));
                usuario.setTelefoneFuncionario(resultadoQuery.getString("telefoneFuncionario"));
                usuario.setPermissaoAdmin(resultadoQuery.getInt("permissaoAdmin"));
                usuario.setEmpresa(resultadoQuery.getInt("fkEmpresa"));
                usuario.setTipoFuncionario(resultadoQuery.getInt("tipoFuncionario"));
            }

        } catch (SQLException e) {
            System.err.println("Query malsucedida");
            geradorDeLog.adicionarLog("ERRO", "Não foi possível consultar os dados do funcionário, em decorrência de falha da plataforma Azure");
        }
        return usuario;

    }

}
