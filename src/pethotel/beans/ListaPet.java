
package pethotel.beans;

import java.util.ArrayList;
import java.util.List;


public class ListaPet {
    
    private static final List<Pet> lista = new ArrayList<>();

        
    public static List<Pet> Listar() {
        return lista;
    }

    public static void Adicionar(Pet pet) {
        lista.add(pet);
    }
    
}
