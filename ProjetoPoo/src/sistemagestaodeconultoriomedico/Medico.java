package sistemagestaodeconultoriomedico;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Medico extends Usuario {
    private Especialidade especialidade;
    private String crm;
    private Map<DayOfWeek, Set<LocalTime>> disponibilidadeRecorrente = new HashMap<>();

    // Construtor completo
    public Medico(String nome, String senha, Especialidade especialidade, String crm) {
        super.setNome(nome);
        super.setSenha(senha);
        super.setTipo("medico");
        this.especialidade = especialidade;
        this.crm = crm;
    }

    
    
    
    // Construtor vazio (se necessário para serialização)
    public Medico() {
    }

    // ========== MÉTODOS DE DISPONIBILIDADE ==========
    public void adicionarHorarioRecorrente(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFim) {
        Set<LocalTime> horarios = new TreeSet<>();
        LocalTime horaAtual = horaInicio;
        
        while (!horaAtual.isAfter(horaFim)) {
            horarios.add(horaAtual);
            horaAtual = horaAtual.plusMinutes(30); // Intervalos de 30 minutos
        }
        
        disponibilidadeRecorrente.put(dia, horarios);
    }

    public boolean removerHorario(DayOfWeek dia, LocalTime hora) {
        if (disponibilidadeRecorrente.containsKey(dia)) {
            return disponibilidadeRecorrente.get(dia).remove(hora);
        }
        return false;
    }
    
    

    public Set<LocalTime> getHorariosDisponiveis(DayOfWeek dia) {
        return Collections.unmodifiableSet(
            disponibilidadeRecorrente.getOrDefault(dia, Collections.emptySet())
        );
    }

    // ========== GETTERS/SETTERS ==========
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

    public Map<DayOfWeek, Set<LocalTime>> getDisponibilidadeRecorrente() {
    return disponibilidadeRecorrente;
}

    public void setDisponibilidadeRecorrente(Map<DayOfWeek, Set<LocalTime>> disponibilidade) {
        this.disponibilidadeRecorrente = new HashMap<>(disponibilidade);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.crm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        return Objects.equals(this.crm, other.crm);
    }
    
    
    
    
}