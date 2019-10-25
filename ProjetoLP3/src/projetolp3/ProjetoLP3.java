package projetolp3;

import view.FrmLogin;
import dao.daoUsuarioImp;
import model.Usuario;

public class ProjetoLP3 {

    public static void main(String[] args) {
//        FrmLogin log = new FrmLogin();
//        
//        log.setVisible(true);

        daoUsuarioImp dao = new daoUsuarioImp();
        Usuario user = new Usuario();
        
        user.setNome("admin");
        user.setSenha("admin");
        user.setEmail("admin@email.com");
        user.setQtdAcesso(0);
        user.setStatus(0);
        
        dao.salvar(user);
        
    }

}
