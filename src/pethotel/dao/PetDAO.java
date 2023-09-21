
package pethotel.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pethotel.beans.Pet;


public class PetDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public PetDAO() {
        
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    
    }
    
    public void inserir(Pet pet) {
        String sql = "INSERT INTO pet(tutor, nome, sexo, idade, peso, castrado, data_cuidados, cuidados_especiais, medicamentos) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pet.getTutor());
            stmt.setString(2, pet.getNome());
            stmt.setString(3, pet.getSexo());
            stmt.setString(4, pet.getIdade());
            stmt.setString(5, pet.getPeso());
            stmt.setString(6, pet.getCastrado());
            stmt.setString(7, pet.getDataCuidados());
            stmt.setString(8, pet.getCuidadosEspeciais());
            stmt.setString(9, pet.getMedicamentos());
            stmt.execute();

        }
        
        catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
        }
    }
    
    
    public List<Pet> getPetP (String nome){
        
        String sql = "SELECT * FROM pet WHERE nome LIKE ?";
        
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            List<Pet> listaPets = new ArrayList<>();

            while (rs.next()) {
                
                Pet pet = new Pet();

                pet.setId(rs.getInt("id"));
                pet.setTutor(rs.getString("tutor"));
                pet.setNome(rs.getString("nome"));
                pet.setSexo(rs.getString("sexo"));
                pet.setIdade(rs.getString("idade"));
                pet.setPeso(rs.getString("peso"));
                pet.setCastrado(rs.getString("castrado"));
                pet.setDataCuidados(rs.getString("data_cuidados"));
                pet.setCuidadosEspeciais(rs.getString("cuidados_especiais"));
                pet.setMedicamentos(rs.getString("medicamentos"));
                
                listaPets.add(pet);
                      
            }
            
            return listaPets;
            
        }
        
        catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    
     public List<Pet> getPet() {
        
        String sql = "SELECT * FROM pet";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();            

            List<Pet> listaPets = new ArrayList<>();

            while (rs.next()) { 
                Pet pet = new Pet ();

                pet.setId(rs.getInt("id"));
                pet.setTutor(rs.getString("tutor"));
                pet.setNome(rs.getString("nome"));
                pet.setSexo(rs.getString("sexo"));
                pet.setIdade(rs.getString("idade"));
                pet.setPeso(rs.getString("peso"));
                pet.setCastrado(rs.getString("castrado"));
                pet.setDataCuidados(rs.getString("data_cuidados"));
                pet.setCuidadosEspeciais(rs.getString("cuidados_especiais"));
                pet.setMedicamentos(rs.getString("medicamentos"));
                             
                listaPets.add(pet);    
            }
            return listaPets;
  
        }
        catch (Exception e) {
            return null;
        }
    }
    
    
        public void excluir (int id){

            String sql = "DELETE FROM pet WHERE id = ?";
            
            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, id);

                stmt.execute();
               
            }
            catch (Exception e) {
                System.out.println("Erro ao excluir pet: " + e.getMessage());
            }

    }
    
}
