package controller;

import dao.BilheteriaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Bilheteria;
import util.Session;

import java.time.LocalTime;
import java.util.List;

public class BilheteriaController {

    @FXML private TableView<Bilheteria> tabelaBilheterias;
    @FXML private TableColumn<Bilheteria, String> colNome;
    @FXML private TableColumn<Bilheteria, Double> colPreco;
    @FXML private TableColumn<Bilheteria, Integer> colQuantidade;
    @FXML private TableColumn<Bilheteria, LocalTime> colHorarioFechamento;
    @FXML private TableColumn<Bilheteria, Void> colAcao;
    @FXML private Button btnvoltarmenu;

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(data -> data.getValue().nomeProperty());
        colPreco.setCellValueFactory(data -> data.getValue().precoProperty().asObject());
        colQuantidade.setCellValueFactory(data -> data.getValue().quantidadeProperty().asObject());
        colHorarioFechamento.setCellValueFactory(data -> data.getValue().horarioFechamentoProperty());

        adicionarColunaComprar();
        tabelaBilheterias.setItems(carregarBilheterias());
    }

    private void adicionarColunaComprar() {
        colAcao = new TableColumn<>("Ação");

        Callback<TableColumn<Bilheteria, Void>, TableCell<Bilheteria, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Bilheteria, Void> call(final TableColumn<Bilheteria, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button("Comprar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Bilheteria b = getTableView().getItems().get(getIndex());

                            int quantidadeAtual = b.getQuantidade();
                            if (quantidadeAtual > 0) {
                                int novaQuantidade = quantidadeAtual - 1;

                                BilheteriaDAO dao = new BilheteriaDAO();
                                dao.atualizarQuantidade(b.getNome(), novaQuantidade); // agora usa o nome da atração
                                b.setQuantidade(novaQuantidade);
                                tabelaBilheterias.refresh(); // atualiza visualmente
                            } else {
                                Alert alerta = new Alert(Alert.AlertType.WARNING);
                                alerta.setTitle("Atenção");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Ingressos esgotados!");
                                alerta.showAndWait();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };

        colAcao.setCellFactory(cellFactory);
        tabelaBilheterias.getColumns().add(colAcao);
    }

    private ObservableList<Bilheteria> carregarBilheterias() {
        BilheteriaDAO dao = new BilheteriaDAO();
        List<Bilheteria> lista = dao.listarBilheterias();
        return FXCollections.observableArrayList(lista);
    }

    @FXML
    private void voltarMenu() {
        Stage stage = (Stage) btnvoltarmenu.getScene().getWindow();
        Session.changeScene(stage, "main.fxml");
    }
}
