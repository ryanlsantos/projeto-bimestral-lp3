package conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    public Connection conexao;
//    public Statement stm;
//    public ResultSet rs;

    private final String url = "jdbc:mysql://localhost:3306/db_projlp3";
    private final String usuario = "root";
    private final String senha = "";
    private final String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
//            JOptionPane.showMessageDialog(null, "Conectado com sucesso!!", "CONEXÃO", 1);
        } catch (ClassNotFoundException drive) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado!\n" + drive, "CONEXÃO", 0);
        } catch (SQLException fonte) {
            JOptionPane.showMessageDialog(null, "Banco de dados não encontrado!\n" + fonte, "CONEXÃO", 0);
        }
        return conexao; // Retorna conexao
    }

//    public void desconecta() {
//        try {
//            conexao.close();
//            JOptionPane.showMessageDialog(null, "Desconectado com sucesso!!", "CONEXÃO", 1);
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Não desconectado!\n" + erro, "CONEXÃO", 0);
//        }
//    }
    
//    public void executarSQL(String sql) {
//        try {
//            stm = conexao.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
//            rs = stm.executeQuery(sql);
//        } catch (SQLException erroexec) {
//            JOptionPane.showMessageDialog(null, "Erro ao consultar no Banco!\n\nErro: " + erroexec + "\n\nSQL: " + sql, "CONEXÃO", 0);
//        }
//    }
}
