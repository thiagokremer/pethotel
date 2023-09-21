
package pethotel.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pethotel.beans.Check;



public class CheckDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public CheckDAO() {
        
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    
    }
    
    public void inserir(Check check) {
        String sql = "INSERT INTO hospedagem(nomePet, data_entrada, data_saida, diarias, valor, obs) VALUES " + "(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, check.getNomePet());
            stmt.setString(2, check.getDataEntrada());
            stmt.setString(3, check.getDataSaida());
            stmt.setString(4, check.getDiarias());
            stmt.setString(5, check.getValor());
            stmt.setString(6, check.getObs());
            stmt.execute();

        }
        
        catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
        }
    }
    
    
    public List<Check> getCheckP (String nome){

        String sql = "SELECT * FROM hospedagem WHERE nomePet LIKE ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            List<Check> listaChecks = new ArrayList<>();

            while (rs.next()) {

                Check check = new Check();

                check.setId(rs.getInt("id"));
                check.setNomePet(rs.getString("nomePet"));
                check.setDataEntrada(rs.getString("data_entrada"));
                check.setDataSaida(rs.getString("data_saida"));
                check.setDiarias(rs.getString("diarias"));
                check.setValor(rs.getString("valor"));
                check.setObs(rs.getString("obs"));
                
                listaChecks.add(check);

            }

            return listaChecks; 
        }

        catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    
     public List<Check> getCheck() {
        
        String sql = "SELECT * FROM hospedagem";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();            

            List<Check> listaChecks = new ArrayList<>();

            while (rs.next()) { 
                Check check = new Check();

                check.setId(rs.getInt("id"));
                check.setNomePet(rs.getString("nomePet"));
                check.setDataEntrada(rs.getString("data_entrada"));
                check.setDataSaida(rs.getString("data_saida"));
                check.setDiarias(rs.getString("diarias"));
                check.setValor(rs.getString("valor"));
                check.setObs(rs.getString("obs"));
              
              
                listaChecks.add(check);    
            }
            return listaChecks;
  
        }
        catch (Exception e) {
            return null;
        }
    }
    
    
        public void excluir (int id){

            String sql = "DELETE FROM hospedagem WHERE id = ?";
            
            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, id);

                stmt.execute();
               
            }
            catch (Exception e) {
                System.out.println("Erro ao excluir hospedagem: " + e.getMessage());
            }

    }
              
    
}
