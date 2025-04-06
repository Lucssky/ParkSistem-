package model;

public class Ingresso {
    private String atracao;
    private double preco;

    public Ingresso(String atracao, double preco) {
        this.atracao = atracao;
        this.preco = preco;
    }

    public Ingresso(Atracao atracao, Cliente cliente, int quantidade) {
        this.atracao = atracao.getNome(); // Pega o nome da atração
        this.preco = atracao.getPreco() * quantidade; // Calcula o total com base na quantidade
    }

    public String getAtracao() {
        return atracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
