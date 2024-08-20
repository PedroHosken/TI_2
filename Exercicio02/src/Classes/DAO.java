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
		
		  //retornar
		    return status;
	  }
	
}
