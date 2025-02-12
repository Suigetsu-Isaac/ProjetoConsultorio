package sistemagestaodeconultoriomedico;
import java.io.Serializable;

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String nome;
    private String senha;
    private String tipo;
    
    public Usuario(){
        
    }
    
    public Usuario(String nome,String senha,String tipo){
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
