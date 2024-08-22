package Classes;
import java.sql.*;

public class DAO {
	//definir dados
	  private Connection conexao;
	//construtor padrão
	  public DAO() {
		  conexao = null;
	  }
	//realizar a conexão
	  public boolean conectar() {
		  String driverName = "org.postgresql.Driver";
		  String serverName = "localhost";
		  String mydatabase = "teste";
		  int porta = 5432;
		  String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		  String username = "pg87066@gmail.com";
		  String password = "Rimagajupe@4";
		  boolean status = false;
		  //realizar o teste
		    try {
		    	Class.forName(driverName);
		    	conexao = DriverManager.getConnection(url, username, password);
		    	status = (conexao == null);
		    	System.out.println("Conexao efetuada com o PostGres");
		    	}catch(ClassNotFoundException e) {
		    		System.err.println("Conexao nao efetuada com o Postgrees -- Driver Nao Encontrado --" + e.getMessage());	
		    	}catch(SQLException e) {
		    		System.err.println("Conexao nao efetuada com o Postgrees 2 -- " + e.getMessage());
		    	}
		  //retornar
		    return status;
	  }
	  
	  //metodo para fechar a conexao
	    public boolean close() {
	    	boolean status = false;
	    	try {
	    		conexao.close();
	    		status = true;
	    	}catch(SQLException e) {
	    		System.err.println(e.getMessage());
	    	}
	    	//retornar
	    	  return status;
	    }
	    
	   //metodo de inserir usuario
	      public boolean inserirUsuario(Usuario usuario) {
	    	  boolean status = false;
	    	  try {
	    		  Statement st = conexao.createStatement();
	    		  st.executeUpdate("INSERT INTO usuario (codigo, login, senha, sexo)"
	    				  + "VALUES ("+usuario.getCode()+", '"+usuario.getLogin() + "', '"
	    				  + usuario.getSenha() + "', '" +usuario.getSexo() + "');");  		  
	    		  st.close();
	    		  status = true;
	    	  }catch(SQLException u) {
	    		  throw new RuntimeException(u);
	    	  }
	    	  return status;
	      }
	      
	      //metodo de atualizar o usuario
	        public boolean atualizarUsuario(Usuario usuario) {
	        	boolean status = false;
	        	try {
	        		Statement st = conexao.createStatement();
	        		String sql = "UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '"
	        				+ usuario.getSenha() + "' , sexo = '" + usuario.getSexo() + "' "
	        				+ "WHERE codigo = " + usuario.getCode();
	        		st.executeUpdate(sql);
	        		st.close();
	        		status = true;
	        	} catch(SQLException u) {
	        		throw new RuntimeException(u);
	        	}
	        	//retornar
	        	  return status;
	        }
	        
	        //metodo de excluir Usuario
	          public boolean excluirUsuario(int codigo) {
	        	  boolean status = false;
	        	  try {
	        		  Statement st = conexao.createStatement();
	        		  st.executeUpdate("DELETE FROM usuario WHERE codigo = " + codigo);
	        		  st.close();
	        		  status = true;
	        	  }catch(SQLException u) {
	        		  throw new RuntimeException(u);
	        	  }
	        	  //retornar
	        	   return status;
	          }
	          
	          //lista de usuario
	            public Usuario[] getUsuarios() {
	            	Usuario[] usuarios = null;
	            	
	            	try {
	            		Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            		ResultSet rs = st.executeQuery("SELECT * FROM usuario ");
	            		if(rs.next()) {
	            			rs.last();
	            			usuarios = new Usuario[rs.getRow()];
	            			rs.beforeFirst();
	            			
	            			for(int i = 0; rs.next(); i++) {
	            				usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0));
	            			}
	            		}
	            		st.close();
	            	} catch (Exception e) {
	            		System.err.println(e.getMessage());
	            	}
	            	return usuarios;
	            }
	            
	
}
