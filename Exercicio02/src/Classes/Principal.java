package Classes;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		dao.conectar();
		
		//inserir um elemento na tabela
		  Usuario usuario = new Usuario(11, "pablo","pablo",'M');
		  if(dao.inserirUsuario(usuario) == true) {
			  System.out.println("Insercao feita com sucesso ->" + usuario.toString());
		  }
		//mostrar usuarios
		  System.out.println("--- Mostrar todos Usuarios---");
		  Usuario[] usuarios = dao.getUsuarios();
		  for(int i = 0; i < usuarios.length; i++) {
			  System.out.println(usuarios[i].toString());
		  }
		//Atualizar usuario
		  usuario.setSenha("nova senha:");
		  dao.atualizarUsuario(usuario);
		//mostrar usuarios
		  System.out.println("--- Mostrar todos Usuarios---");
		  usuarios = dao.getUsuarios();
		  for(int i = 0; i < usuarios.length; i++) {
			  System.out.println(usuarios[i].toString());
		  }
		//excluir usuario
		  dao.excluirUsuario(usuario.getCode());
		//mostrar usuarios
		  System.out.println("--- Mostrar todos Usuarios---");
		  usuarios = dao.getUsuarios();
		  for(int i = 0; i < usuarios.length; i++) {
			  System.out.println(usuarios[i].toString());
		  }
		dao.close();
	}

}
