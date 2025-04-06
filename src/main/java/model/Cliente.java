package model;

public class Cliente {
    private String nome;
    private String email;

    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
}
