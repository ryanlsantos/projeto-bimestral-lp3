package dao;

import java.util.List;
import model.Usuario;

public interface daoUsuario {
    public void salvar(Usuario usuario);
    public void alterar(Usuario usuario);
    public void excluir(int id);
    public List<Usuario> getUsuarios();
    
}
