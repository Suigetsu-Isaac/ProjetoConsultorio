package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class Paciente implements Serializable{
    private String nome;
    private String cpf;
    private LocalDate data;
    private String telefone;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Paciente(String nome, String cpf, LocalDate data, String telefone, String senha){
             this.nome = nome;
             this.cpf = cpf;
             this.data = data;
             this.telefone = telefone;
             this.senha = senha;
             
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

    public int getIdade() {
        return Period.between(data, LocalDate.now()).getYears();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    
}
