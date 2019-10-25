package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;

public class daoCarroImp implements daoCarro {

    Connection con = null;
    PreparedStatement pstm = null;

    @Override
    public void salvar(Carro carro) {
        con = new Conexao().getConnection();

        String inserir = "INSERT INTO tb_carro(marca, modelo, ano) VALUES (?, ?, ?)";
        try {
            pstm = con.prepareStatement(inserir);
            pstm.setString(1, carro.getMarca());
            pstm.setString(2, carro.getModelo());
            pstm.setInt(3, carro.getAno());
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Carro inserido com sucesso!!", "SALVAR", 1);
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

    public void alterar(Carro carro) {
        con = new Conexao().getConnection();
        
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar "
                + "o registro de id " + carro.getId() + "?", "ALTERAR", JOptionPane.YES_NO_OPTION, 2);
        
        String alterar = "UPDATE tb_carro SET marca = ?, modelo = ?, ano = ? WHERE id = ?";
        try {
            pstm = con.prepareStatement(alterar);
            pstm.setString(1, carro.getMarca());
            pstm.setString(2, carro.getModelo());
            pstm.setInt(3, carro.getAno());
            pstm.setInt(4, carro.getId());
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Carro alterado com sucesso!!", "ALTERAR", 1);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + erro + "\n\nSQL: " + alterar, "ALTERAR - ERRO", 0);
        } finally {
            try {
                con.close();
//                JOptionPane.showMessageDialog(null, "Desconectado com sucesso!", "ALTERAR", 1);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:\n" + erro, "ALTERAR - ERRO", 0);
            }
        }
    }

    public void excluir(int id) {
        con = new Conexao().getConnection();
        
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir "
                + "o registro de id " + id + "?", "EXCLUÍR", JOptionPane.YES_NO_OPTION, 2);

        String excluir = "DELETE FROM tb_carro WHERE id = ?";
        try {
            if (op == 0) {
                pstm = con.prepareStatement(excluir);
                pstm.setInt(1, id);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!", "EXCLUÍR", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Cancelado!", "EXCLUÍR", 2);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluír:\n" + erro + "\n\nSQL: " + excluir, "EXCLUÍR - ERRO", 0);
        } finally {
            try {
                con.close();
//                JOptionPane.showMessageDialog(null, "Desconectado com sucesso!", "EXCLUÍR", 1);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:\n" + erro, "EXCLUÍR - ERRO", 0);
            }
        }
    }

    @Override
    public List<Carro> getCarros() {
        List<Carro> lista = new ArrayList<Carro>();
        ResultSet rs = null;
        
        con = new Conexao().getConnection();

        try {
            pstm = con.prepareStatement("SELECT * FROM tb_carro");
            rs = pstm.executeQuery();
            rs.first();
            do {
                Carro carro = new Carro();

                carro.setId(rs.getInt("id"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setAno(rs.getInt("ano"));

                lista.add(carro);

            } while (rs.next());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados:\n" + erro, "LISTA - ERRO", 0);
        } finally {
            try {
                con.close();
//                JOptionPane.showMessageDialog(null, "Desconectado com sucesso!", "LISTA", 1);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:\n" + erro, "LISTA - ERRO", 0);
            }
        }

        return lista;
    }
}
