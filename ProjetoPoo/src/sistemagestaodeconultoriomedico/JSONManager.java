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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSONManager {
    private static final String PACIENTES_FILE = "pacientes.json";
    private static final String MEDICOS_FILE = "medicos.json";
    private static final String CONSULTAS_FILE = "consultas.json";
    private static final String ESPECIALIDADE_FILE = "especialidade.json";

    private static Gson getGson() {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()) // ADICIONE ESTA LINHA
            .setPrettyPrinting()
            .create();
    }

    private static <T> void salvarLista(String arquivo, List<T> lista) {
        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar " + arquivo + ": " + e.getMessage());
        }
    }

    private static <T> List<T> carregarLista(String arquivo, Type tipoLista) {
        Gson gson = getGson();
        File file = new File(arquivo);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, tipoLista);
        } catch (IOException | JsonSyntaxException e) {
            System.err.println("Erro ao carregar " + arquivo + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ========== PACIENTES ==========
    public static void salvarPacientes(List<Paciente> pacientes) {
        salvarLista(PACIENTES_FILE, pacientes);
    }

    public static List<Paciente> carregarPacientes() {
        return carregarLista(PACIENTES_FILE, new TypeToken<ArrayList<Paciente>>() {}.getType());
    }

    // ========== MÉDICOS ==========
    public static void salvarMedicos(List<Medico> medicos) {
        salvarLista(MEDICOS_FILE, medicos);
    }

    public static List<Medico> carregarMedicos() {
        return carregarLista(MEDICOS_FILE, new TypeToken<ArrayList<Medico>>() {}.getType());
    }

    // ========== CONSULTAS ==========
    public static void salvarConsultas(List<Consulta> consultas) {
        salvarLista(CONSULTAS_FILE, consultas);
    }

    public static List<Consulta> carregarConsultas() {
        return carregarLista(CONSULTAS_FILE, new TypeToken<ArrayList<Consulta>>() {}.getType());
    }

    // ========== ESPECIALIDADES ==========
    public static void salvarEspecialidades(List<Especialidade> especialidades) {
        salvarLista(ESPECIALIDADE_FILE, especialidades);
    }

    public static List<Especialidade> carregarEspecialidades() {
        return carregarLista(ESPECIALIDADE_FILE, new TypeToken<ArrayList<Especialidade>>() {}.getType());
    }

    // ========== OPERAÇÕES ESPECÍFICAS PARA PACIENTES ==========
    public static void salvarPaciente(Paciente paciente) {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.add(paciente);
        salvarPacientes(pacientes);
    }

    public static void editarPaciente(Paciente paciente, int index) {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.set(index, paciente);
        salvarPacientes(pacientes);
    }

    public static void removerPaciente(Paciente p) {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.remove(p);
        salvarPacientes(pacientes);
    }

    // ========== OPERAÇÕES ESPECÍFICAS PARA MÉDICOS ==========
    public static void salvarMedico(Medico medico) {
        List<Medico> medicos = carregarMedicos();
        medicos.add(medico);
        salvarMedicos(medicos);
    }

    public static void atualizarMedico(Medico medico) {
        List<Medico> medicos = carregarMedicos();
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCrm().equals(medico.getCrm())) {
                medicos.set(i, medico); // Atualiza o médico na lista
                break;
            }
        }
        salvarMedicos(medicos);
    }

    public static void removerMedico(Medico medico) {
        List<Medico> medicos = carregarMedicos();
        medicos.remove(medico);
        salvarMedicos(medicos);
    }

    // ========== OPERAÇÕES ESPECÍFICAS PARA ESPECIALIDADES ==========
    public static void salvarEspecialidade(Especialidade especialidade) {
        List<Especialidade> especialidades = carregarEspecialidades();
        especialidades.add(especialidade);
        salvarEspecialidades(especialidades);
    }

    // ========== OPERAÇÕES ESPECÍFICAS PARA CONSULTAS ==========
    public static void salvarConsulta(Consulta consulta) {
        List<Consulta> consultas = carregarConsultas();
        consultas.add(consulta);
        salvarConsultas(consultas);
    }
    
    public static void removerConsulta(Consulta consulta) {
    List<Consulta> consultas = carregarConsultas();
        System.out.println("Remover Consulta: "+consultas.remove(consulta));
    salvarConsultas(consultas);
}
    
    public static List<LocalTime> getHorariosOcupados(Medico medico, LocalDate data) {
        List<Consulta> consultas = carregarConsultas();
        return consultas.stream()
                        .filter(c -> c.getMedico().equals(medico) && c.getData().equals(data))
                        .map(Consulta::getHora)
                        .collect(Collectors.toList());
    }
}