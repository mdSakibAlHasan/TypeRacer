module com.example.typeracer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.typeracer to javafx.fxml;
    exports com.example.typeracer;
}