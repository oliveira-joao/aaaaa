package dominios;

/**
 *
 * @author Victor
 */
public class Funcionario {

    Integer idFuncionario;
    String nomeFuncionario;
    String loginFuncionario;
    String senhaFuncionario;
    String emailFuncionario;
    String telefoneFuncionario;
    Integer permissaoAdmin;
    Integer empresa;
    Integer tipoFuncionario;

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getLoginFuncionario() {
        return loginFuncionario;
    }

    public void setLoginFuncionario(String loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getPermissaoAdmin() {
        if (permissaoAdmin == 1) {
            return "Administrador";
        } else {
            return "Funcionário comum";
        }
    }

    public void setPermissaoAdmin(Integer permissaoAdmin) {
        this.permissaoAdmin = permissaoAdmin;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }
    
    public Integer getTipoFuncionario() {
        return tipoFuncionario;
    }
    
    public void setTipoFuncionario(Integer tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    @Override
    public String toString() {
        return "Informações do Funcionario"
                + "\nidFuncionario: " + idFuncionario
                + "\nnomeFuncionario: " + nomeFuncionario
                + "\nloginFuncionario: " + loginFuncionario
                + "\nsenhaFuncionario: " + senhaFuncionario
                + "\nemailFuncionario: " + emailFuncionario
                + "\ntelefoneFuncionario: " + telefoneFuncionario
                + "\npermissaoAdmin: " + permissaoAdmin
                + "\nempresa: " + empresa
                + "\ntipoFuncionario: " + tipoFuncionario;
    }

}
