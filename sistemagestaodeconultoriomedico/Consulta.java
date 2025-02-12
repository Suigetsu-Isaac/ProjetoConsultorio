package sistemagestaodeconultoriomedico;

public class Consulta {
    private Paciente paciente; // Paciente envolvido na consulta
    private Medico medico;     // Médico responsável pela consulta
    private double horario;    // Horário da consulta (ex: 9.5 para 9h30)

    // Construtor
    public Consulta(Paciente paciente, Medico medico, double horario) {
        this.paciente = paciente;
        this.medico = medico;
        this.horario = horario;
    }

    // Getters e Setters
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

    public double getHorario() {
        return horario;
    }

    public void setHorario(double horario) {
        this.horario = horario;
    }

    // Método toString para exibir os detalhes da consulta de forma legível
    @Override
    public String toString() {
        return "Consulta {" +
                "Paciente = " + paciente.getNome() +
                ", Médico = " + medico.getNome() +
                ", Horário = " + horario +
                '}';
    }
}
