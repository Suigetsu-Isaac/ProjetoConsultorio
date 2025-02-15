/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projetopoo;

import java.util.List;
import sistemagestaodeconultoriomedico.JSONManager;
import sistemagestaodeconultoriomedico.Medico;
import sistemagestaodeconultoriomedico.Paciente;
import sistemagestaodeconultoriomedico.Especialidade;
import sistemagestaodeconultoriomedico.Consulta;
public interface JsonManagerAtributos {
    final List<Paciente> pacientes = JSONManager.carregarPacientes();
    final List<Medico> medicos = JSONManager.carregarMedicos();
    final List<Especialidade> especialidades = JSONManager.carregarEspecialidades();
    final List<Consulta> consultas = JSONManager.carregarConsultas();
}
