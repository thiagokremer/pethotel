
package pethotel.dao;

import conexao.Conexao;
import java.sql.Connection;
import pethotel.beans.Tutor;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TutorDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public TutorDAO() {
        
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    
    }
    
    public void inserir(Tutor tutor) {
        String sql = "INSERT INTO tutor(cpf, nome, endereco, contato, email, telefones) VALUES " + "(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, tutor.getCPF());
            stmt.setString(2, tutor.getNome());
            stmt.setString(3, tutor.getEndereco());
            stmt.setString(4, tutor.getContato());
            stmt.setString(5, tutor.getEmail());
            stmt.setString(6, tutor.getTelefones());
            stmt.execute();

        }
        
        catch (Exception e) {
            System.out.println("Erro ao cadastrar tutor." + e.getMessage());
        }
        
     }
    
    
    public List<Tutor> getTutorP (String nome){
        
        String sql = "SELECT * FROM tutor WHERE nome LIKE ?";
        
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            List<Tutor> listaTutores = new ArrayList<>();

            while (rs.next()) {
                
                Tutor tutor = new Tutor();

                tutor.setId(rs.getInt("id"));
                tutor.setCPF(rs.getString("cpf"));
                tutor.setNome(rs.getString("nome"));
                tutor.setEndereco(rs.getString("endereco"));
                tutor.setContato(rs.getString("contato"));
                tutor.setEmail(rs.getString("email"));
                tutor.setTelefones(rs.getString("telefones"));
                listaTutores.add(tutor);
                      
            }
            
            return listaTutores; 
        }
        
        catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    
    public List<Tutor> getTutor() {
        
        String sql = "SELECT * FROM tutor";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();            

            List<Tutor> listaTutores = new ArrayList<>();

            while (rs.next()) { 
                Tutor tutor = new Tutor();

                tutor.setId(rs.getInt("id"));
                tutor.setCPF(rs.getString("cpf"));
                tutor.setNome(rs.getString("nome"));
                tutor.setEndereco(rs.getString("endereco"));
                tutor.setContato(rs.getString("contato"));
                tutor.setEmail(rs.getString("email"));
                tutor.setTelefones(rs.getString("telefones"));
              
                listaTutores.add(tutor);    
            }
            return listaTutores;
  
        }
        catch (Exception e) {
            return null;
        }
    }
    
    
        public void excluir (int id){

            String sql = "DELETE FROM tutor WHERE id = ?";
            
            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, id);

                stmt.execute();
               
            }
            catch (Exception e) {
                System.out.println("Erro ao excluir tutor: " + e.getMessage());
            }
        }
              
    

}


