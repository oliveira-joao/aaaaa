package model.dao;

import conexao.ConexaoSmy;
import dominios.Computador;
import dominios.Funcionario;
import funcionamento.sistema.CapturaInicialDadosComputador;
import funcionamento.sistema.GeradorDeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinicius.n.ferreira
 */
public class ComputadorDao {

    private GeradorDeLog geradorDeLog = new GeradorDeLog();
    private ConexaoSmy conexao = new ConexaoSmy();
    private Connection con = conexao.conectar();
    private PreparedStatement pstmSelect;
    private PreparedStatement pstmInsert;
    private PreparedStatement pstmSelectId;
    private ResultSet resultadoQuery;
    private ResultSet resultadoQueryIdMaquina;
    private Integer idFuncionario;
    private Boolean resultadoInsert;
    private Computador computadorFuncionario = new Computador();
    private CapturaInicialDadosComputador capturaDadosComputador = new CapturaInicialDadosComputador();

    public Computador buscarDadosComputador(Funcionario funcionarioLogado) {
        try {
            String queryMaquina = "SELECT * FROM computador WHERE fkFuncionario = ?";
            pstmSelect = con.prepareStatement(queryMaquina);
            pstmSelect.setInt(1, funcionarioLogado.getIdFuncionario());
            resultadoQuery = pstmSelect.executeQuery();

            if (resultadoQuery.next()) {
                computadorFuncionario.setIdComputador(resultadoQuery.getInt("idComputador"));
                computadorFuncionario.setModelo(resultadoQuery.getString("modelo"));
                computadorFuncionario.setMarca(resultadoQuery.getString("marca"));
                computadorFuncionario.setNomeCPU(resultadoQuery.getString("nomeCPU"));
                computadorFuncionario.setTotalRAM(resultadoQuery.getDouble("totalRAM"));
                computadorFuncionario.setModeloDisco(resultadoQuery.getString("modeloDisco"));
                computadorFuncionario.setTotalDisco(resultadoQuery.getDouble("totalDisco"));
                computadorFuncionario.setSistemaOperacional(resultadoQuery.getString("sistemaOperacional"));
                computadorFuncionario.setFuncionario(resultadoQuery.getInt("fkFuncionario"));
                geradorDeLog.adicionarLog("INFO", "Máquina do funcionário " + funcionarioLogado.getNomeFuncionario() + " já cadastrada anteriormente!");

            } else {
                try {
                    String insertMaquina = "INSERT INTO computador VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
                    pstmInsert = con.prepareStatement(insertMaquina);
                    pstmInsert.setString(1, capturaDadosComputador.getModeloComputador());
                    pstmInsert.setString(2, capturaDadosComputador.getMarcaComputador());
                    pstmInsert.setString(3, capturaDadosComputador.getNomeCPU());
                    pstmInsert.setFloat(4, capturaDadosComputador.getTotalRAM());
                    if (capturaDadosComputador.getModeloDisco().contains("unknown")) {
                        pstmInsert.setString(5, "Storage do servidor em nuvem");
                    } else {
                        pstmInsert.setString(5, capturaDadosComputador.getModeloDisco());
                    }
                    pstmInsert.setFloat(6, capturaDadosComputador.getTotalDisco());
                    pstmInsert.setString(7, capturaDadosComputador.getSistemaOperacional());
                    pstmInsert.setInt(8, funcionarioLogado.getIdFuncionario());
                    resultadoInsert = pstmInsert.execute();

                    String queryIdMaquina = "SELECT idComputador FROM computador WHERE fkFuncionario = ?";
                    pstmSelectId = con.prepareStatement(queryIdMaquina);
                    pstmSelectId.setInt(1, funcionarioLogado.getIdFuncionario());
                    resultadoQueryIdMaquina = pstmSelectId.executeQuery();
                    while (resultadoQueryIdMaquina.next()) {
                        computadorFuncionario.setIdComputador(resultadoQueryIdMaquina.getInt("idComputador"));
                    }

                    computadorFuncionario.setModelo(capturaDadosComputador.getModeloComputador());
                    computadorFuncionario.setMarca(capturaDadosComputador.getMarcaComputador());
                    computadorFuncionario.setNomeCPU(capturaDadosComputador.getNomeCPU());
                    computadorFuncionario.setTotalRAM(Double.valueOf(capturaDadosComputador.getTotalRAM()));
                    if (capturaDadosComputador.getModeloDisco().contains("unknown")) {
                        computadorFuncionario.setModeloDisco("Storage do servidor em nuvem");
                    } else {
                        computadorFuncionario.setModeloDisco(capturaDadosComputador.getModeloDisco());
                    }
                    computadorFuncionario.setTotalDisco(Double.valueOf(capturaDadosComputador.getTotalDisco()));
                    computadorFuncionario.setSistemaOperacional(capturaDadosComputador.getSistemaOperacional());
                    computadorFuncionario.setFuncionario(funcionarioLogado.getIdFuncionario());
                    geradorDeLog.adicionarLog("INFO", "Máquina do funcionário " + funcionarioLogado.getNomeFuncionario() + " cadastrada com sucesso!");

                    return computadorFuncionario;

                } catch (SQLException e) {
                    System.err.println("Query malsucedida");
                    geradorDeLog.adicionarLog("ERRO", "Não foi possível cadastrar a máquina do funcionário " + funcionarioLogado.getNomeFuncionario());

                }
            }

        } catch (SQLException e) {
            System.err.println("Query malsucedida");
            geradorDeLog.adicionarLog("ERRO", "Não foi possível consultar o cadastro da máquina do funcionário " + funcionarioLogado.getNomeFuncionario());

        }
        return computadorFuncionario;
    }
}
