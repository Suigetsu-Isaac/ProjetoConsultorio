package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Object agenda;
    public static void main(String[] args) {
        // Lista de pacientes
       List<Paciente> pacientes = new ArrayList<>();
       pacientes.add(new Paciente("João Silva", "123.456.789-00", 30, "87988346690", "Asma"));
       pacientes.add(new Paciente("Maria Livia", "987.654.321-00", 25, "87988560199", "Alergia"));

       // Lista de médicos
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. Carlos", "Cardiologia", "CRM123456", List.of(9.0, 14.5, 16.0)));
        medicos.add(new Medico("Dra. Ana", "Dermatologia", "CRM654321", List.of(10.0, 15.0)));

        Lista de consultas
        Agenda agenda = new Agenda();
        agenda.adicionarConsulta(new Consulta(pacientes.get(0), medicos.get(0), 9.0));
        agenda.adicionarConsulta(new Consulta(pacientes.get(1), medicos.get(1), 10.0));
        List<Consulta> consultas = agenda.listarConsultas();

         Salvar os dados em arquivos JSON
        salvarDadosEmJson("C:/Users/livia/Desktop/Projeto final/sistemaGestaoDeConultorioMedico/pacientes.json", pacientes);
        salvarDadosEmJson("medicos.json", medicos);
        salvarDadosEmJson("consultas.json", consultas);
    }

    // Método genérico para salvar dados em JSON
    private static <T> void salvarDadosEmJson(String caminhoArquivo, List<T> dados) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Configuração para JSON legível
        String json = gson.toJson(dados);

        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(json);
            System.out.println("Dados salvos com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados em JSON: " + e.getMessage());
        }
    }
}
