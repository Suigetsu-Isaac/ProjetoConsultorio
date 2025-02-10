package sistemagestaodeconultoriomedico;
import java.io.Serializable;

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    String login;
    private String nome;
    private String senha;
    String cpf;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
