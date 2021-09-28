package dominios;

/**
 *
 * @author vinicius.n.ferreira
 */
public class Relato {

    private Integer idRelato = 0;
    private String relatorio = "";
    private String sentimento = "";
    private String momentoRelato = "";
    private Integer funcionario = 0;

    public Relato() {
    }
    
    public Relato(String sentimento, String momentoRelato) {
        this.sentimento = sentimento;
        this.momentoRelato = momentoRelato;
    }

    public Integer getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(Integer idRelato) {
        this.idRelato = idRelato;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public String getMomentoRelato() {
        return momentoRelato;
    }

    public void setMomentoRelato(String momentoRelato) {
        this.momentoRelato = momentoRelato;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Informações do relato"
                + "\nidRelato: " + idRelato
                + "\nrelatorio: " + relatorio
                + "\nsentimento: " + sentimento
                + "\nmomentoRelato: " + momentoRelato
                + "\nfuncionario: " + funcionario;
    }
}
