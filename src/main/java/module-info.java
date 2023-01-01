module com.example.novdictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.novdictionary to javafx.fxml;
    exports com.example.novdictionary;
}