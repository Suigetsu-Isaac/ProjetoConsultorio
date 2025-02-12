package sistemagestaodeconultoriomedico;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class Medico {
    private String nome;
    private String senha;
    private Especialidade especialidade;
    private String crm;
    private Map<String,List<Integer>>  disponibilidade;
  

    // Construtor
    public Medico(String nome, String senha, Especialidade especialidade, String crm, Map<String,List<Integer>> disponibilidade) {
        this.nome = nome;
        this.senha = senha;
        this.especialidade = especialidade;
        this.crm = crm;
        this.disponibilidade = disponibilidade;
    }
    
    public Medico(){
        
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Map<String, List<Integer>> getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Map<String, List<Integer>> disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

  
    
}
 

