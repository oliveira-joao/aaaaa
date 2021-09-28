package model.dao;

import conexao.ConexaoMySqlDocker;
import conexao.ConexaoSmy;
import funcionamento.sistema.AprovacaoConexaoMysql;
import funcionamento.sistema.GeradorDeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vinicius.n.ferreira
 */
public class LeituraHardwareDao {

    private ConexaoSmy conexao = new ConexaoSmy();
    private Connection con = conexao.conectar();
    private PreparedStatement pstm = null;
    private ResultSet resultadoInsert = null;
    private Boolean retornouResultado = false;
    private GeradorDeLog geradorDeLog = new GeradorDeLog();
    private ConexaoMySqlDocker conexaoMysql;
    private Connection conectarMysql;

    public LeituraHardwareDao() {
        if (AprovacaoConexaoMysql.verificarSeDeveConectarAoMysql()) {
            conexaoMysql = new ConexaoMySqlDocker();
            conectarMysql = conexaoMysql.conectarAoDocker();
        }
    }

    public void inserirMonitoramento(Integer pctCPU, Integer pctRAM, Integer pctDisco, String hLeitura, Integer fkPc) {

        try {
            String insertLeitura = "INSERT INTO LeituraHardware VALUES (?, ?, ?, ?, ?) ";
            pstm = con.prepareStatement(insertLeitura);
            pstm.setInt(1, pctCPU);
            pstm.setInt(2, pctRAM);
            pstm.setInt(3, pctDisco);
            pstm.setString(4, hLeitura);
            pstm.setInt(5, fkPc);

            retornouResultado = pstm.execute();
            if (!retornouResultado) {
                System.out.println("");
            } else {
                resultadoInsert = pstm.getResultSet();

            }
        } catch (SQLException e) {
            System.err.println("Query malsucedida");
            geradorDeLog.adicionarLog("ERRO", "Não foi possível inserir os dados de monitoramento");
        }
    }

    public void selectMetricasCpuMysql() {

        System.out.println("\nSelecionar tudo da tabela metricasCPU");
        String query = "SELECT * FROM metricasCPU";
        try {
            Statement st = conectarMysql.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer idLeitura = rs.getInt("idLeitura");
                String momentoLeitura = rs.getString("momentoLeitura");
                Double usoCPU = rs.getDouble("usoCPU");

                System.out.println(String.format("idLeitura: %d"
                        + "\nmomentoLeitura: %s"
                        + "\nusoCPU: %f",
                        idLeitura,
                        momentoLeitura,
                        usoCPU));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertMetricasCpuMysql(Double pctCPU, String hLeitura) {

        System.out.println("\nInserindo dados na tabela metricasCPU do MySQL...");
        try {
            Statement st = conectarMysql.createStatement();
            // no need to fill the id as its value is auto-incremented
            st.executeUpdate("INSERT INTO metricasCPU (momentoLeitura, usoCPU) VALUES ('" + hLeitura + "', " + pctCPU + ")");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir dados na tabela metricasCPU");
        }
    }

    public void selectMetricasRamMysql() {

        System.out.println("\nSelecionar tudo da tabela metricasRAM");
        String query = "SELECT * FROM metricasRAM";
        try {
            Statement st = conectarMysql.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer idLeitura = rs.getInt("idLeitura");
                String momentoLeitura = rs.getString("momentoLeitura");
                Double usoRAM = rs.getDouble("usoRAM");

                System.out.println(String.format("idLeitura: %d"
                        + "\nmomentoLeitura: %s"
                        + "\nusoRAM: %f",
                        idLeitura,
                        momentoLeitura,
                        usoRAM));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertMetricasRamMysql(Double pctRAM, String hLeitura) {

        System.out.println("\nInserindo dados na tabela metricasRAM do MySQL...");
        try {
            Statement st = conectarMysql.createStatement();
            // no need to fill the id as its value is auto-incremented
            st.executeUpdate("INSERT INTO metricasRAM (momentoLeitura, usoRAM) VALUES ('" + hLeitura + "', " + pctRAM + ")");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir dados na tabela metricasRAM");
        }
    }

    public void selectMetricasDiscoMysql() {

        System.out.println("\nSelecionar tudo da tabela metricasDisco");
        String query = "SELECT * FROM metricasDisco";
        try {
            Statement st = conectarMysql.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer idLeitura = rs.getInt("idLeitura");
                String momentoLeitura = rs.getString("momentoLeitura");
                Double usoDisco = rs.getDouble("usoDisco");

                System.out.println(String.format("idLeitura: %d"
                        + "\nmomentoLeitura: %s"
                        + "\nusoDisco: %f",
                        idLeitura,
                        momentoLeitura,
                        usoDisco));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertMetricasDiscoMysql(Double pctDisco, String hLeitura) {

        System.out.println("\nInserindo dados na tabela metricasDisco do MySQL...");
        try {
            Statement st = conectarMysql.createStatement();
            // no need to fill the id as its value is auto-incremented
            st.executeUpdate("INSERT INTO metricasDisco (momentoLeitura, usoDisco) VALUES ('" + hLeitura + "', " + pctDisco + ")");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir dados na tabela metricasDisco");
        }
    }

}
