package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Consulta> consultas;

    // Construtor
    public Agenda() {
        this.consultas = new ArrayList<>();
    }

    // Método para adicionar uma consulta
    public boolean adicionarConsulta(Consulta consulta) {
        for (Consulta c : consultas) {
            if (c.getHorario() == consulta.getHorario() && c.getMedico().equals(consulta.getMedico())) {
                return false; // Horário já ocupado pelo mesmo médico
            }
        }
        consultas.add(consulta);
        return true;
    }

    // Método para listar todas as consultas
    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    // Método para salvar consultas em JSON
    public void salvarEmJson(String caminhoArquivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Configuração para JSON legível
        String jsonConsultas = gson.toJson(consultas);

        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(jsonConsultas);
            System.out.println("Arquivo JSON salvo com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
        }
    }
}
