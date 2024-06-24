package com.example.javafx_basic_ui_learn;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    public TableColumn<Book, String> columnTitle;
    public TableColumn<Book, String> columnGenre;
    public TableColumn<Book, String> columnAuthor;
    public TableColumn<Book, Integer> columnQuantity;
    public TableColumn<Book, String> columnPublisher;
    public TableColumn<Book, Integer> columnPages;
    public TableColumn<Book, String> columnDescription;
    public TableView<Book> bookTable;

    static ObservableList<Book> observableBookList = FXCollections.observableArrayList();

    public void initialize() {
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        columnPages.setCellValueFactory(new PropertyValueFactory<>("pages"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        bookTable.setItems(observableBookList);
    }

    public void handleAddItem(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("AddBookDialog.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 300);
            Stage stage = new Stage();
            stage.setTitle("Add book");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleAddClient(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("AddClientDialog.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Add Client");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleNewTransaction(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("TransactionDialog.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            TransactionDialogController dialogController = fxmlLoader.getController();
            dialogController.setBookTable(bookTable);
            Stage stage = new Stage();
            stage.setTitle("New Transaction");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBookToList(Book book) {
        observableBookList.add(book);
    }
}