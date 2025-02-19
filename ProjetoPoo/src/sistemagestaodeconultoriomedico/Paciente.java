package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Paciente extends Usuario implements Serializable{
  
    private String cpf;
    private LocalDate data;
    private String telefone;
    

    
    
    public Paciente(String nome, String cpf, LocalDate data, String telefone, String senha){
             super.setNome(nome);
             this.cpf = cpf;
             this.data = data;
             this.telefone = telefone;
             super.setSenha(senha);
             super.setTipo("paciente");
             
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

    
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Paciente paciente = (Paciente) obj;
    return Objects.equals(this.cpf, paciente.cpf);
}

@Override
public int hashCode() {
    return Objects.hash(cpf);
}
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    
}
