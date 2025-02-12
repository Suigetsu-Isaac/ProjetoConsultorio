package sistemagestaodeconultoriomedico;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String senha;
    private String especialidade;
    private String crm;
    private List<Double> disponibilidade = new ArrayList<>();

    // Construtor
    public Medico(String nome, String especialidade, String crm, List<Double> disponibilidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.disponibilidade = disponibilidade; // Corrigido para aceitar uma lista
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Double> getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(List<Double> disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
  