package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;

public class DisplayItemController {
    @FXML
    private Label foodItemLabel; // Label to display current food item data

    public void setFoodItemList(List<FoodItem> foodItemList) {
        if (foodItemList == null || foodItemList.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("No Items");
            alert.setHeaderText(null);
            alert.setContentText("No items have been added to display.");
            alert.showAndWait();
            foodItemLabel.setText("No items available.");
        } else {
            StringBuilder displayText = new StringBuilder();
            for (FoodItem item : foodItemList) {
                displayText.append("Name: ").append(item.getName())
                        .append("\nStored Date: ").append(item.getStoredDate())
                        .append("\nExpiration Date: ").append(item.getExpirationDate())
                        .append("\n\n"); // Add some space between items
            }
            foodItemLabel.setText(displayText.toString());
        }
    }
}
