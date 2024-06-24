package com.example.javafx_basic_ui_learn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TransactionDialogController {
    public ComboBox<Book> bookComboBox;
    public Spinner<Integer> quantitySpinner;
    public ComboBox<String> clientComboBox;
    public GridPane gridPane;

    private ObservableList<Book> availableBooks;
    private TableView<Book> m_bookTable;

    @FXML
    public void initialize() {
        gridPane.setPadding(new Insets(10, 0, 0, 10));

        availableBooks = FXCollections.observableArrayList();
        availableBooks.addAll(HelloController.observableBookList);
        bookComboBox.setItems(availableBooks);

        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1, 1);
        quantitySpinner.setValueFactory(valueFactory);

        ObservableList<String> clientNames = FXCollections.observableArrayList();

        bookComboBox.valueProperty().addListener((obs, oldBook, newBook) -> {
            if (newBook != null) {
                valueFactory.setMax(newBook.getQuantity());
                if (valueFactory.getMax() < 1) {
                    valueFactory.setMax(1);
                }
                quantitySpinner.getValueFactory().setValue(1);
            }
        });
    }

    public void setBookTable(TableView<Book> bookTable) {
        m_bookTable = bookTable;
    }

    public void handleConfirm(ActionEvent actionEvent) {
        Book selectedBook = bookComboBox.getValue();
        int quantityToSell = quantitySpinner.getValue();

        String selectedClient = clientComboBox.getValue();

        if (selectedBook != null && quantityToSell > 0 && quantityToSell <= selectedBook.getQuantity() && selectedClient != null) {
            selectedBook.setQuantity(selectedBook.getQuantity() - quantityToSell);

            m_bookTable.refresh();
            Logger.logTransaction(quantityToSell, selectedBook.getTitle(), selectedClient);

            gridPane.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid selection");
            alert.setContentText("Please select a valid book and quantity.");
            alert.showAndWait();
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        gridPane.getScene().getWindow().hide();
    }

    public void updateClientComboBox(String newClientName) {
        if (clientComboBox != null && newClientName != null && !newClientName.isEmpty()) {
            clientComboBox.getItems().add(newClientName);
            clientComboBox.getSelectionModel().select(newClientName);
        }
    }
    public void handleAddNewClient(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("AddClientDialog.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Add Client");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            String newClientName = ((AddClientDialogController) fxmlLoader.getController()).getNameField().getText();
            newClientName += " " + ((AddClientDialogController) fxmlLoader.getController()).getSurnameField().getText();

            if (newClientName != null && !newClientName.isEmpty()) {
                clientComboBox.getItems().add(newClientName);
                clientComboBox.getSelectionModel().select(newClientName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
