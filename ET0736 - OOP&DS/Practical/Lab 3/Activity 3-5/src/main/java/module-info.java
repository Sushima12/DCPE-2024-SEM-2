module com.example.activity3_5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.activity3_5 to javafx.fxml;
    exports com.example.activity3_5;
}