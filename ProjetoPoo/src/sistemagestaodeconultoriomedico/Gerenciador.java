package sistemagestaodeconultoriomedico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();

        System.out.println("Bem-vindo ao sistema de gestão do consultório médico!");
        System.out.println("Vamos cadastrar os pacientes.");
        System.out.println("Digite o número de pacientes que deseja cadastrar:");
        
        int numeroDePacientes = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

        // Loop para capturar os dados de cada paciente
        for (int i = 1; i <= numeroDePacientes; i++) {
            System.out.println("Cadastro do paciente #" + i);

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Digite o histórico médico: ");
            String historicoMedico = scanner.nextLine();

            // Criar um novo paciente e adicioná-lo à lista
            Paciente paciente = new Paciente(nome, cpf, idade, telefone, historicoMedico);
            pacientes.add(paciente);

            System.out.println("Paciente #" + i + " cadastrado com sucesso!\n");
        }

        // Converter a lista de pacientes para JSON organizado
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonPacientes = gson.toJson(pacientes);

        // Salvar no arquivo JSON
        try (FileWriter writer = new FileWriter("C:/Users/livia/Desktop/Projeto final/sistemaGestaoDeConultorioMedico/src/sistemagestaodeconultoriomedico/pacientes.json")) {
            writer.write(jsonPacientes);
            System.out.println("Todos os pacientes foram salvos com sucesso no arquivo JSON!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
        }
    }
}

