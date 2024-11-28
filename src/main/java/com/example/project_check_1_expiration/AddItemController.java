package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
    private Button exportButton;

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

    @FXML
    public void onExportButtonClick() {
        try (FileWriter writer = new FileWriter("food_items.csv")) {
            List<FoodItem> items = DataStore.getFoodItemList();

            // Write header
            writer.write("Name,Category,Stored Date,Expiration Date\n");

            // Write data
            for (FoodItem item : items) {
                writer.write(String.format("%s,%s,%s,%s\n",
                        item.getName(),
                        item.getCategory(),
                        item.getStoredDate(),
                        item.getExpirationDate()));
            }

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Export Success");
            alert.setHeaderText(null);
            alert.setContentText("Data successfully exported to food_items.csv.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Export Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while exporting data.");
            alert.showAndWait();
        }
    }
}
