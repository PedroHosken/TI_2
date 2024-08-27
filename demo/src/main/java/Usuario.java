public class Usuario {
	
	// Atributos da classe
	private int codigo;
	private String senha;
	private String login;
	private char sexo;

	public Usuario() {
		this.codigo = 0;  
		this.senha = "";
		this.login = "";
		this.sexo = 'N';
	}

	public Usuario(int codigo, String login, String senha, char sexo) {
		this.codigo = codigo;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
	}

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

	@Override
	public String toString() {
		return "Usuario [ codigo = " + codigo + ", login = " + login + ", senha = " + senha + ", sexo = " + sexo + " ]";
	}
}
