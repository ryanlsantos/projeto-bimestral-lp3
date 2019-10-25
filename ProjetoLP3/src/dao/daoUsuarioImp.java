package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class daoUsuarioImp implements daoUsuario {
    
    Connection con = null;
    PreparedStatement pstm = null;

    @Override
    public void salvar(Usuario usuario) {
        con = new Conexao().getConnection();

        String inserir = "INSERT INTO tb_usuario(nome, email, senha, qtdAcesso, status) VALUES (?, ?, ?, ?, ?)";
        try {
            pstm = con.prepareStatement(inserir);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setInt(4, usuario.getQtdAcesso());
            pstm.setInt(5, usuario.getStatus());
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!!", "SALVAR", 1);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" + erro + "\n\nSQL: " + inserir, "SALVAR - ERRO", 0);
        } finally {
            try {
                con.close();
//                JOptionPane.showMessageDialog(null, "Desconectado com sucesso!", "SALVAR", 1);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:\n" + erro, "SALVAR - ERRO", 0);
            }
        }

    }

    @Override
    public void alterar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
