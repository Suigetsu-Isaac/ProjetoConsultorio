package sistemagestaodeconultoriomedico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private LocalTime hora;
    private boolean concluida;

    public Consulta(Paciente paciente, Medico medico, LocalDate data, LocalTime hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
        this.concluida = false;
    }

    // ========== GETTERS & SETTERS ==========
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void finalizarConsulta() {
        this.concluida = true;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Consulta outraConsulta = (Consulta) obj;

        // Comparar com base em atributos únicos (ex: data, horário e médico)
        return this.getData().equals(outraConsulta.getData()) &&
               this.getHora().equals(outraConsulta.getHora()) &&
               this.getMedico().equals(outraConsulta.getMedico());
    }

    @Override
    public int hashCode() {
        // Gerar um hash com base nos mesmos atributos usados no equals
        return Objects.hash(getData(), getHora(), getMedico());
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "Paciente: " + paciente.getNome() +
                ", Médico: " + medico.getNome() +
                ", Data: " + data.format(DateTimeFormatter.ISO_DATE) +
                ", Hora: " + hora.format(DateTimeFormatter.ofPattern("HH:mm")) +
                '}';
    }
}