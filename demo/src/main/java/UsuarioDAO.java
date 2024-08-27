import java.sql.*;

public class UsuarioDAO {
    private DAO conexao;

    public UsuarioDAO() {
    }

    public boolean inserirUsuario(Usuario usuario) {
        conexao = new DAO();
        boolean status = false;
        try {
            String query = "INSERT INTO usuario (login, senha, sexo) VALUES (?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            st.setString(3, String.valueOf(usuario.getSexo()));

            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        conexao = new DAO();
        boolean status = false;
        int codigo = usuario.getCode();
        try{
        String queryMain = "SELECT codigo from usuario Where codigo = " + codigo;
        PreparedStatement st2 = conexao.prepareStatement(queryMain);
        ResultSet rs = st2.executeQuery();
        if (rs.next()) {
            status = true;  // Se entrar aqui, o código já existe
        } else{
            return status;
        }

        rs.close();
        st2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String query = "UPDATE usuario SET login = ?, senha = ?, sexo = ? WHERE codigo = ?";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            st.setString(3, String.valueOf(usuario.getSexo()));
            st.setInt(4, usuario.getCode());  

            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean excluirUsuario(int codigo) {
        conexao = new DAO();
        boolean status = false;
        try {
            String query = "DELETE FROM usuario WHERE codigo = ?";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setInt(1, codigo);

            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public Usuario[] getUsuarios() {
        conexao = new DAO();
        Usuario[] usuarios = null;
        try {
            ResultSet rs = conexao.executeQuery("SELECT * FROM usuario");
            if (rs.next()) {
                rs.last();
                usuarios = new Usuario[rs.getRow()];  
                rs.beforeFirst();

                for (int i = 0; rs.next(); i++) {
                    usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0));
                }
            }
            rs.close();
            conexao.closeStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao.close();
        return usuarios;
    }

    public Usuario buscarUsuarioPorCodigo(int codigo) {
        conexao = new DAO();
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuario WHERE codigo = ?";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setInt(1, codigo);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getInt("codigo"), rs.getString("login"), rs.getString("senha"), rs.getString("sexo").charAt(0));
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
