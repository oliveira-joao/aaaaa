
package dominios;

/**
 *
 * @author vinicius.n.ferreira
 */
public class LeituraHardware {
    
    private Integer idLeitura;
    private Integer porcentagemUsoCPU;
    private Integer porcentagemUsoRAM;
    private Integer porcentagemUsoDisco;
    private String horarioLeitura;
    private Integer computador;

    public LeituraHardware() {
    }

    public LeituraHardware(Integer idLeitura, Integer porcentagemUsoCPU, Integer porcentagemUsoRAM, Integer porcentagemUsoDisco, String horarioLeitura, Integer computador) {
        this.idLeitura = idLeitura;
        this.porcentagemUsoCPU = porcentagemUsoCPU;
        this.porcentagemUsoRAM = porcentagemUsoRAM;
        this.porcentagemUsoDisco = porcentagemUsoDisco;
        this.horarioLeitura = horarioLeitura;
        this.computador = computador;
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Integer getPorcentagemUsoCPU() {
        return porcentagemUsoCPU;
    }

    public void setPorcentagemUsoCPU(Integer porcentagemUsoCPU) {
        this.porcentagemUsoCPU = porcentagemUsoCPU;
    }

    public Integer getPorcentagemUsoRAM() {
        return porcentagemUsoRAM;
    }

    public void setPorcentagemUsoRAM(Integer porcentagemUsoRAM) {
        this.porcentagemUsoRAM = porcentagemUsoRAM;
    }

    public Integer getPorcentagemUsoDisco() {
        return porcentagemUsoDisco;
    }

    public void setPorcentagemUsoDisco(Integer porcentagemUsoDisco) {
        this.porcentagemUsoDisco = porcentagemUsoDisco;
    }

    public String getHorarioLeitura() {
        return horarioLeitura;
    }

    public void setHorarioLeitura(String horarioLeitura) {
        this.horarioLeitura = horarioLeitura;
    }

    public Integer getFkComputador() {
        return computador;
    }

    public void setFkComputador(Integer computador) {
        this.computador = computador;
    }

        @Override
    public String toString() {
        return "Informações do monitoramento"
                + "\nidLeitura: " + idLeitura
                + "\nporcentagemUsoCPU: " + porcentagemUsoCPU
                + "\nporcentagemUsoRAM: " + porcentagemUsoRAM
                + "\nporcentagemUsoDisco: " + porcentagemUsoDisco
                + "\nhorarioLeitura: " + horarioLeitura
                + "\ncomputador: " + computador;
    }
}
