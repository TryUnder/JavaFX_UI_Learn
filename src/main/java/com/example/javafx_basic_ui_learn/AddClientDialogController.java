package com.example.javafx_basic_ui_learn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddClientDialogController {
    public TextField nameField;
    public TextField surnameField;
    public TextField addressField;
    public GridPane gridPane;
    private TransactionDialogController transactionDialogController;

    public void setTransactionDialogController(TransactionDialogController controller) {
        transactionDialogController = controller;
    }

    public void initialize() {
        gridPane.setPadding(new Insets(10, 0, 0, 10));
    }

    public void handleAddClient(ActionEvent actionEvent) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String address = addressField.getText();

        gridPane.getScene().getWindow().hide();

        if (transactionDialogController != null) {
            transactionDialogController.updateClientComboBox(name + " " + surname);
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        gridPane.getScene().getWindow().hide();
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getSurnameField() {
        return surnameField;
    }
}
