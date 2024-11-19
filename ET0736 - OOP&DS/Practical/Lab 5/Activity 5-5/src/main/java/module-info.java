module com.example.activity5_5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.activity5_5 to javafx.fxml;
    exports com.example.activity5_5;
}