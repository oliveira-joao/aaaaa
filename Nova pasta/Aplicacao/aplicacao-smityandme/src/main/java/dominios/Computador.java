package dominios;

/**
 *
 * @author vinicius.n.ferreira
 */
public class Computador {

    private Integer idComputador;
    private String modelo;
    private String marca;
    private String nomeCPU;
    private Double totalRAM;
    private String modeloDisco;
    private Double totalDisco;
    private String sistemaOperacional;
    private Integer funcionario;

    public Computador() {
    }

    public Computador(String modelo, String marca, String nomeCPU, Double totalRAM, String modeloDisco, Double totalDisco, String sistemaOperacional, Integer funcionario) {
        this.modelo = modelo;
        this.marca = marca;
        this.nomeCPU = nomeCPU;
        this.totalRAM = totalRAM;
        this.modeloDisco = modeloDisco;
        this.totalDisco = totalDisco;
        this.sistemaOperacional = sistemaOperacional;
        this.funcionario = funcionario;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNomeCPU() {
        return nomeCPU;
    }

    public void setNomeCPU(String nomeCPU) {
        this.nomeCPU = nomeCPU;
    }

    public Double getTotalRAM() {
        return totalRAM;
    }

    public void setTotalRAM(Double totalRAM) {
        this.totalRAM = totalRAM;
    }

    public String getModeloDisco() {
        return modeloDisco;
    }

    public void setModeloDisco(String modeloDisco) {
        this.modeloDisco = modeloDisco;
    }

    public Double getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Double totalDisco) {
        this.totalDisco = totalDisco;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Informações do Computador"
                + "\nidComputador: " + idComputador
                + "\nmodelo: " + modelo
                + "\nmarca: " + marca
                + "\nomeCPU: " + nomeCPU
                + "\totalRAM: " + totalRAM
                + "\nmodeloDisco: " + modeloDisco
                + "\ntotalDisco=" + totalDisco
                + "\nsistemaOperacional: " + sistemaOperacional
                + "\nfuncionario: " + funcionario;

    }

}
