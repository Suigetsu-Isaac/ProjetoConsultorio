/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sistemagestaodeconultoriomedico.Consulta;
import sistemagestaodeconultoriomedico.JSONManager;
import sistemagestaodeconultoriomedico.SessionManager;
import sistemagestaodeconultoriomedico.Usuario;
public class TelaPaciente  extends javax.swing.JFrame{

    private Usuario user = SessionManager.getUsuarioLogado();

    public TelaPaciente() {
         System.out.println("Usuário: " + user.getNome());
    initComponents();
    
// No construtor ou no método de inicialização
jPanelConsultas.setBackground(Color.WHITE); // Definir cor de fundo do painel

    // Configurar o layout do jPanelConsultas
    jPanelConsultas.setLayout(new java.awt.GridLayout(0, 1)); 
   
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    jPanelConsultas.setPreferredSize(new java.awt.Dimension(500, 300));
   
// Teste simples para verificar se o painel está funcionando
    pegarConsulta();
    jPanelConsultas.revalidate();
    jPanelConsultas.repaint();
    
    
    }

    
 private void pegarConsulta() {
        // Carregar todas as consultas do JSON
        List<Consulta> consultas = JSONManager.carregarConsultas();
        System.out.println("Total de consultas carregadas: " + consultas.size());

        // Filtrar consultas do paciente logado
        List<Consulta> consultasPaciente = consultas.stream()
            .filter(consulta -> consulta.getPaciente().getNome().equals(user.getNome()))
            .toList();

        System.out.println("Consultas do paciente: " + consultasPaciente.size());

        // Exibir consultas na interface
        exibirConsultas(consultasPaciente);
    }

  private void exibirConsultas(List<Consulta> consultas) {
    System.out.println("Exibindo consultas no painel...");
    jPanelConsultas.removeAll(); // Limpar o painel antes de adicionar novas consultas

    for (Consulta consulta : consultas) {
        System.out.println("Adicionando consulta: " + consulta);

        // Verificar se os dados da consulta não são nulos
        if (consulta.getMedico() == null || consulta.getHora() == null || consulta.getData() == null) {
            System.out.println("Dados da consulta incompletos: " + consulta);
            continue; // Pular para a próxima consulta
        }

        String medico = consulta.getMedico().getNome();
        String horario = consulta.getHora().toString();
        String data = consulta.getData().toString();

        JLabel labelMedico = new JLabel("Médico: " + medico);
        labelMedico.setForeground(Color.BLACK);
        JLabel labelHorario = new JLabel("Horário: " + horario);
        labelHorario.setForeground(Color.BLACK);
        JLabel labelData = new JLabel("Data: " + data);
        labelData.setForeground(Color.BLACK);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> verificarExcluirConsulta(consulta));

        // Painel para cada consulta
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT)); // Layout horizontal
        panelConsulta.add(labelMedico);
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
    
    private void verificarExcluirConsulta(Consulta consulta){
        int resposta = JOptionPane.showConfirmDialog(
    this,
    "Tem certeza que deseja excluir esta consulta?",
    "Confirmar Exclusão",
    JOptionPane.YES_NO_OPTION
);

if (resposta == JOptionPane.YES_OPTION) {
    excluirConsulta(consulta);
}
    }
    
    private void excluirConsulta(Consulta consulta) {
        // Lógica para excluir a consulta
        JSONManager.removerConsulta(consulta);
        pegarConsulta(); // Atualizar a lista de consultas
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelConsultas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));
        setForeground(new java.awt.Color(255, 51, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Minhas Consultas");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setText("Nova Consulta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setText("Meus Dados");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanelConsultas.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanelConsultas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaDadosPaciente tela = new TelaDadosPaciente();
                tela.setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaConsultaPaciente tela= new TelaConsultaPaciente();
                tela.setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelConsultas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
