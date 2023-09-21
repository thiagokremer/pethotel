
package pethotel.beans;

import java.util.ArrayList;
import java.util.List;


public class ListaCheck {
    
        private static final List<Check> lista = new ArrayList<>();

        
    public static List<Check> Listar() {
        return lista;
    }

    public static void Adicionar(Check check) {
        lista.add(check);
    }
    
}
