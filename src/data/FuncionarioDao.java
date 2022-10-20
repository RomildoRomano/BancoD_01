
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;






   public class FuncionarioDao {
    
    
    Connection conn;
    PreparedStatement st; 
    ResultSet rs;
    
    // Metodo conectar
    public boolean conectar(){
                       

              
        
        
        try {
            
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colaborador","root","");
            return true;
       }catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
        }


        
          
             
   
    
        




           
       
  
    
    //***************************************************************
    
    //Metodo Salvar
  public int salvar( Funcionario funcionario){

        int status;
        try {
            st = conn.prepareStatement("INSERT INTO cadastro VALUES(?,?,?,?)");
            
            st.setString(1, funcionario.getMatricula());
            st.setString(2, funcionario.getNome());  
            st.setString(3, funcionario.getCargo());
            st.setDouble(4, funcionario.getSalario());
            status = st.executeUpdate();
            return status; // retorna - 1
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
           return ex.getErrorCode();
        
}    
}

      //*****************************************************  
    
        
        public void desconectar(){
           try {
            conn.close();
        } catch (SQLException ex) {
          
        }
       }
        
     //********************************************************   
        public Funcionario consultar(String matricula){
             Funcionario funcionario = new Funcionario();
             
        try {
                st = conn.prepareStatement("SELECT * FROM cadastro WHERE matricula = ?" );
                st.setString(1,matricula);
                rs = st.executeQuery();
            
            if(rs.next()){
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                return funcionario;
            }else {
                return null;
                
            }
        }   catch (SQLException ex) {
            return null;
        }
        }
        
        //**************************************************************
        
        public boolean excluir(String matricula){
        try {
            st = conn.prepareStatement("DELETE FROM cadastro WHERE matricula = ?" );
            st.setString(1,matricula);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
           return false;
}
        
        }    
   }
  
  
    
   
        
        

