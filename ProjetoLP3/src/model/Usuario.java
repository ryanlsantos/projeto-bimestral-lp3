package model;

public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String email;
    private int qtdAcesso;
    private int status;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String email, int qtdAcesso, int status) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.qtdAcesso = qtdAcesso;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQtdAcesso() {
        return qtdAcesso;
    }

    public void setQtdAcesso(int qtdAcesso) {
        this.qtdAcesso = qtdAcesso;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
