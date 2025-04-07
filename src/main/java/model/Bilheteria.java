package model;

import javafx.beans.property.*;

import java.time.LocalTime;

public class Bilheteria {
    private final StringProperty nome;
    private final DoubleProperty preco;
    private final IntegerProperty quantidade;
    private final ObjectProperty<LocalTime> horarioFechamento;
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    public Bilheteria(String nome, double preco, int quantidade, LocalTime fechamento) {
        this.nome = new SimpleStringProperty(nome);
        this.preco = new SimpleDoubleProperty(preco);
        this.quantidade = new SimpleIntegerProperty(quantidade);
        this.horarioFechamento = new SimpleObjectProperty<>(fechamento);
    }

    // Getters e Setters tradicionais
    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public double getPreco() {
        return preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public int getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public LocalTime getHorarioFechamento() {
        return horarioFechamento.get();
    }

    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento.set(horarioFechamento);
    }

    // Propriedades para TableView
    public StringProperty nomeProperty() {
        return nome;
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    public ObjectProperty<LocalTime> horarioFechamentoProperty() {
        return horarioFechamento;
    }

    @Override
    public String toString() {
        return nome.get();
    }
    public int getId() {
        return id.get();
    }


    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
}
