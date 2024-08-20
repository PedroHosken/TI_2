package Classes;

import java.util.*;

public class Usuario {
	
	//dados da classe
	  private int codigo;
	  private String senha;
	  private String login;
	  private char sexo;

	//construtor da classe padrão
	  public Usuario() {
		  this.codigo = 0;
		  this.senha = "";
		  this.login = "";
		  this.sexo = 'N';
	  }
	  
	 //construtor da classe alternativo
	  public Usuario(int codigo, String senha, String login, char sexo) {
		  this.codigo = codigo;
		  this.senha = senha;
		  this.login = login;
		  this.sexo = sexo;
	  }
	  
	 // METÓDOS SET
	  public void setCode(int codigo) {
		  this.codigo = codigo;
	  }
	  public void setSenha(String senha) {
		  this.senha = senha;
	  }
	  public void setLogin(String login) {
		  this.login = login;
	  }
	  public void setSex(char s) {
		  this.sexo = s;
	  }
	  
	 //METÓDOS GET
	  public int getCode() {
		  return codigo;
	  }
	  public String getLogin() {
		  return login;
	  }
	  public String getSenha() {
		  return senha;
	  }
	  public char getSexo() {
		  return sexo;
	  }
	  
	 
}
