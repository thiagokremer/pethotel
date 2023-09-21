
package pethotel;

import conexao.Conexao;
import pethotel.forms.TelaInicial;



public class PetHotel {

 
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
        
     
    
    }
    
}
