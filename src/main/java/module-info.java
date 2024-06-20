module com.example.javafx_basic_ui_learn {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_basic_ui_learn to javafx.fxml;
    exports com.example.javafx_basic_ui_learn;
}