package com.example.javafx_basic_ui_learn;

import javafx.beans.property.*;

public class Book {
    private StringProperty m_title = new SimpleStringProperty();
    private StringProperty m_genre = new SimpleStringProperty();
    private StringProperty m_author = new SimpleStringProperty();
    private IntegerProperty m_quantity = new SimpleIntegerProperty();
    private StringProperty m_publisher = new SimpleStringProperty();
    private IntegerProperty m_pages = new SimpleIntegerProperty();
    private StringProperty m_description = new SimpleStringProperty();


    public Book(String title, String genre, String author, int quantity, String publisher, int pages, String description) {
        m_title.set(title);
        m_genre.set(genre);
        m_author.set(author);
        m_quantity.set(quantity);
        m_publisher.set(publisher);
        m_pages.set(pages);
        m_description.set(description);
    }

    public StringProperty getTitleProperty() { return m_title; }
    public StringProperty getGenreProperty() { return m_genre; }
    public StringProperty getAuthorProperty() { return m_author; }
    public IntegerProperty getQuantityProperty() { return m_quantity; }
    public StringProperty getPublisherProperty() { return m_publisher; }
    public IntegerProperty getPagesProperty() { return m_pages; }
    public StringProperty getDescriptionProperty() { return m_description; }

    public String getTitle() { return m_title.get(); }
    public String getGenre() { return m_genre.get(); }
    public String getAuthor() { return m_author.get(); }
    public int getQuantity() { return m_quantity.get(); }
    public String getPublisher() { return m_publisher.get(); }
    public int getPages() { return m_pages.get(); }
    public String getDescription() { return m_description.get(); }

    public void setTitle(String title) { m_title.set(title); }
    public void setGenre(String genre) { m_genre.set(genre); }
    public void setAuthor(String author) { m_author.set(author); }
    public void setQuantity(int quantity) { m_quantity.set(quantity); }
    public void setPublisher(String publisher) { m_publisher.set(publisher); }
    public void setPages(int pages) { m_pages.set(pages); }
    public void setDescription(String description) { m_description.set(description); }

    @Override
    public String toString() {
        return getTitle() + " " + getGenre() + " Autor: " + getAuthor();
    }
}

