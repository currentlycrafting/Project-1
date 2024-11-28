module com.example.project_check_1_expiration {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project_check_1_expiration to javafx.fxml;
    exports com.example.project_check_1_expiration;
}