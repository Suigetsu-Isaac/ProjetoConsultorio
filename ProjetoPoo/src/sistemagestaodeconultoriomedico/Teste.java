
package sistemagestaodeconultoriomedico;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.HashMap;

public class Teste {

    
    public static void main(String[] args) {
        
        Map<String,List<Integer>> mapa = new HashMap<>();
       
        List<Integer> horario = new ArrayList();
        
        for (int i=8; i<=18;i++){
            horario.add(i);
        }
        
        
        
        
        
        List<Especialidade> esps = JSONManager.carregarEspecialidades();
        
        String[] nome = {"Dr. Ricardo","Dra. Maria"};
        String[] crm = {"19759-PE","13157-PE"};
      
        
        String[] dias = {"Segunda","Terça","Quarta","Quinta","Sexta","Sábado"};
        
        
        
        for (String d: dias){
            mapa.put(d, horario);
        }
        
        int i = 0;
        
        
        
        for (Especialidade e: esps){
            
            
            Medico m = new Medico(nome[i],"1324",e,crm[i],mapa);
            i++;
            
            JSONManager.salvarMedico(m);
        }
        
       
        /*
        Especialidade esp1 = new Especialidade("Cardiologista","Responsavel pelo coração");
        Especialidade esp2 = new Especialidade("Dermatologista","Responsável pela pele");
        
        JSONManager.salvarEspecialidade(esp1);
        JSONManager.salvarEspecialidade(esp2);
        */
    }
    
}
