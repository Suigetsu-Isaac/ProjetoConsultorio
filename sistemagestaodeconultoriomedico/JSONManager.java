package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JSONManager {
    private static final String PACIENTES_FILE = "pacientes.json";
    private static final String MEDICOS_FILE = "medicos.json";
    private static final String CONSULTAS_FILE = "consultas.json";
    
    
    private static Gson getGson() {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();
    }

    public static void salvarPaciente(Paciente paciente) {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.add(paciente);
        salvarPacientes(pacientes);
    }

    public static void salvarPacientes(List<Paciente> pacientes) {
        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(PACIENTES_FILE)) {
            gson.toJson(pacientes, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    public static List<Paciente> carregarPacientes() {
        Gson gson = getGson();
        File file = new File(PACIENTES_FILE);
        
        // Se o arquivo não existe ou está vazio, retorna lista vazia
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type tipoLista = new TypeToken<ArrayList<Paciente>>(){}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException | JsonSyntaxException e) {
            System.err.println("Erro ao carregar pacientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    // Métodos para Médicos (padrão similar)
    public static void salvarMedicos(List<Medico> medicos) {
        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(MEDICOS_FILE)) {
            gson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Medico> carregarMedicos() {
        Gson gson = getGson();
        try (FileReader reader = new FileReader(MEDICOS_FILE)) {
            Type tipoLista = new TypeToken<ArrayList<Medico>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Métodos para Consultas (padrão similar)
    public static void salvarConsultas(List<Consulta> consultas) {
        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(CONSULTAS_FILE)) {
            gson.toJson(consultas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Consulta> carregarConsultas() {
        Gson gson = getGson();
        try (FileReader reader = new FileReader(CONSULTAS_FILE)) {
            Type tipoLista = new TypeToken<ArrayList<Consulta>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
