package funcionamento.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author vinicius.n.ferreira
 */
public class GeradorDeLog {

    private SystemInfo informacoesSistema = new SystemInfo();
    private HardwareAbstractionLayer ha = new SystemInfo().getHardware();
    private ComputerSystem sistema = ha.getComputerSystem();
    private String fabricantePC = sistema.getManufacturer();
    private String dateTimeLog = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Timestamp(System.currentTimeMillis()));
    private String serialPC = sistema.getSerialNumber();
    private String nomeArquivo = String.format("%s_%s_SmityAndMe_log.txt", serialPC, fabricantePC);

    public void adicionarLog(String tipo, String mensagem) {

        try (FileWriter criadorArquivo = new FileWriter(nomeArquivo, true);
                BufferedWriter buffer = new BufferedWriter(criadorArquivo);
                PrintWriter escritorArquivo = new PrintWriter(buffer)) {
            escritorArquivo.append(String.format("%s [%s] [%s] %s\n", dateTimeLog, serialPC, tipo, mensagem));
        } catch (IOException e) {
            Logger.getLogger(GeradorDeLog.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void procurarNoLog(String palavraPesquisada) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(palavraPesquisada)) {
                    System.out.println(linha);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao pesquisar palavra!");
        }
    }

    public String getSerialPC() {
        return serialPC;
    }

    public String getFabricantePC() {
        return fabricantePC;
    }

    public String getDateTimeLog() {
        return dateTimeLog;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

}
