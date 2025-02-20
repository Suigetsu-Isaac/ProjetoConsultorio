/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetopoo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sistemagestaodeconultoriomedico.Consulta;
import sistemagestaodeconultoriomedico.Medico;
import sistemagestaodeconultoriomedico.JSONManager;
import sistemagestaodeconultoriomedico.Paciente;
import sistemagestaodeconultoriomedico.Usuario;
/**
 *
 * @author isaac
 */
public class Funcoes {
    
    
    public static Medico pegarMedico(Usuario user){
        for (Medico m : JSONManager.carregarMedicos()) {
            if (m.getNome().equals(user.getNome())) {
                return m;
                
            }
        }
        
        JOptionPane.showMessageDialog(null, "Médico não encontrado.");
         return null;
        
    }
    
    public static Paciente pegarPaciente(Usuario user){
        for (Paciente p : JSONManager.carregarPacientes()){
          if (p.getNome().equals(user.getNome()))return p;
        }
        JOptionPane.showMessageDialog(null, "Paciente não encontrado");
        return null;
         
    }
    
    public static List<Consulta> carregarConsultas() {
        return JSONManager.carregarConsultas();
    }

    public static List<Consulta> filtrarConsultasPorMedico(List<Consulta> consultas, Medico medico) {
        return consultas.stream()
                .filter(consulta -> consulta.getMedico().getCrm().equals(medico.getCrm()))
                .toList();
    }

    public static List<Consulta> filtrarConsultasPorPaciente(List<Consulta> consultas, Paciente paciente) {
        return consultas.stream()
                .filter(consulta -> consulta.getPaciente().getCpf().equals(paciente.getCpf()))
                .toList();
    }

    public static void exibirConsultas(List<Consulta> consultas, JPanel jPanelConsultas, boolean isMedico) {
        System.out.println("Exibindo consultas no painel...");
        jPanelConsultas.removeAll(); // Limpar o painel antes de adicionar novas consultas

        for (Consulta consulta : consultas) {
            System.out.println("Adicionando consulta: " + consulta);

            // Verificar se os dados da consulta não são nulos
            if (consulta.getMedico() == null || consulta.getHora() == null || consulta.getData() == null) {
                System.out.println("Dados da consulta incompletos: " + consulta);
                continue; // Pular para a próxima consulta
            }

            String nome = isMedico ? consulta.getPaciente().getNome() : consulta.getMedico().getNome();
            String horario = consulta.getHora().toString();
            String data = consulta.getData().toString();

            JLabel labelNome = new JLabel((isMedico ? "Paciente: " : "Médico: ") + nome);
            labelNome.setForeground(Color.BLACK);
            JLabel labelHorario = new JLabel("Horário: " + horario);
            labelHorario.setForeground(Color.BLACK);
            JLabel labelData = new JLabel("Data: " + data);
            labelData.setForeground(Color.BLACK);

            JButton btnExcluir = new JButton("Excluir");
            btnExcluir.addActionListener(e -> verificarExcluirConsulta(consulta, jPanelConsultas));

            // Painel para cada consulta
            JPanel panelConsulta = new JPanel();
            panelConsulta.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Layout horizontal
            panelConsulta.add(labelNome);
            panelConsulta.add(labelHorario);
            panelConsulta.add(labelData);
            panelConsulta.add(btnExcluir);
            panelConsulta.setBackground(Color.WHITE);
            // Adicionar o painel da consulta ao jPanelConsultas
            jPanelConsultas.add(panelConsulta);
        }

        jPanelConsultas.revalidate(); // Atualizar o painel
        jPanelConsultas.repaint();
        System.out.println("Painel de consultas atualizado.");
    }

    private static void verificarExcluirConsulta(Consulta consulta, JPanel jPanelConsultas) {
        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja excluir esta consulta?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            excluirConsulta(consulta, jPanelConsultas);
        }
    }

    private static void excluirConsulta(Consulta consulta, JPanel jPanelConsultas) {
        JSONManager.removerConsulta(consulta);
        // Aqui você pode chamar o método para recarregar as consultas, se necessário
        // Por exemplo, se você quiser recarregar as consultas após a exclusão:
        List<Consulta> consultas = carregarConsultas();
        exibirConsultas(consultas, jPanelConsultas, true); // ou false, dependendo do contexto
    }
    
    
    public static void inicializarTelaPrincipal(JPanel jPanelConsultas, JScrollPane scroll, Runnable pegarConsulta){
        // No construtor ou no método de inicialização
jPanelConsultas.setBackground(Color.WHITE); // Definir cor de fundo do painel

    // Configurar o layout do jPanelConsultas
    jPanelConsultas.setLayout(new java.awt.GridLayout(0, 1)); 
   
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    jPanelConsultas.setPreferredSize(new java.awt.Dimension(500, 300));
   
// Teste simples para verificar se o painel está funcionando
    pegarConsulta.run();
    jPanelConsultas.revalidate();
    jPanelConsultas.repaint();
    
    
    
    }
}
