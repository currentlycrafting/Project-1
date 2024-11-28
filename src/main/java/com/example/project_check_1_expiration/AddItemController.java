package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;

public class AddItemController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField categoryField;

    @FXML
    private DatePicker storedDatePicker;
    @FXML
    private DatePicker expirationDatePicker;
    @FXML
    private Button saveButton;

    @FXML
    public void onSaveButtonClick() {
        String name = nameField.getText();
        String category = categoryField.getText();
        LocalDate storedDate = storedDatePicker.getValue();
        LocalDate expirationDate = expirationDatePicker.getValue();

        if (name == null || name.isEmpty() || storedDate == null || expirationDate == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
        } else {
            FoodItem newItem = new FoodItem(name, category, storedDate, expirationDate);
            DataStore.addItem(newItem);

            nameField.clear();
            categoryField.clear();
            storedDatePicker.setValue(null);
            expirationDatePicker.setValue(null);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Item successfully added.");
            alert.showAndWait();
        }
    }
}
