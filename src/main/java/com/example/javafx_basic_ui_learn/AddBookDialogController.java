package com.example.javafx_basic_ui_learn;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;
import java.util.List;

public class AddBookDialogController {

    public TextField titleField;
    public TextField genreField;
    public TextField authorField;
    public TextField quantityField;
    public TextField publisherField;
    public TextField pagesField;
    public TextField descriptionField;
    public GridPane gridPane;
    private Book newBook = new Book("", "", "", 0, "",0, "");

    @FXML
    public void initialize() {
        gridPane.setPadding(new Insets(10, 0, 0, 10));

        titleField.textProperty().bindBidirectional(newBook.getTitleProperty());
        genreField.textProperty().bindBidirectional(newBook.getGenreProperty());
        authorField.textProperty().bindBidirectional(newBook.getAuthorProperty());
//        quantityField.textProperty().bindBidirectional(newBook.getQuantityProperty(), new IntegerStringConverter());
        publisherField.textProperty().bindBidirectional(newBook.getPublisherProperty());
//        pagesField.textProperty().bindBidirectional(newBook.getPagesProperty(), new IntegerStringConverter());
        descriptionField.textProperty().bindBidirectional(newBook.getDescriptionProperty());

        Bindings.bindBidirectional(quantityField.textProperty(), newBook.getQuantityProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(pagesField.textProperty(), newBook.getPagesProperty(), new NumberStringConverter());
    }

    public void handleAddBook(ActionEvent actionEvent) {
        HelloController.addBookToList(newBook);
        gridPane.getScene().getWindow().hide();
    }

    public void handleCancel(ActionEvent actionEvent) {
        gridPane.getScene().getWindow().hide();
    }
}
