
package pethotel.beans;

import java.util.ArrayList;
import java.util.List;


public class ListaTutor {
    
    private static final List<Tutor> lista = new ArrayList<>();

      // Métodos para acessarmos a lista e adicionarmos novos itens
      public static List<Tutor> Listar() {
          return lista;
      }
      
      public static void Adicionar(Tutor tutor) {
          lista.add(tutor);
      } 
    
}
