package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextAlignment;

import java.util.List;

public class DisplayItemController {
    @FXML
    private TextArea foodItemArea;

    @FXML
    private Button sortByNameButton;

    @FXML
    private Button sortByStoredDateButton;

    @FXML
    private Button sortByExpirationDateButton;

    @FXML
    private Label foodItemLabel;

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
                        .append("\nCategory: ").append(item.getCategory())
                        .append("\nStored Date: ").append(item.getStoredDate().toString())
                        .append("\nExpiration Date: ").append(item.getExpirationDate().toString())
                        .append("\n\n"); // Add some space between items
            }

            foodItemLabel.setText(displayText.toString());
            foodItemLabel.setWrapText(true); // Ensure the text wraps within the label
            foodItemLabel.setTextAlignment(TextAlignment.LEFT); // Align text to the left
            foodItemLabel.setMaxWidth(600); // Optionally set a max width to keep the layout consistent
        }
    }

    @FXML
    public void onSortByNameButtonClick() {
        List<FoodItem> items = DataStore.getFoodItemList();
        SortController.sortByName(items);
        setFoodItemList(items);
        showAlert("Items sorted by name.");
    }

    @FXML
    public void onSortByStoredDateButtonClick() {
        List<FoodItem> items = DataStore.getFoodItemList();
        SortController.sortByStoredDate(items);
        setFoodItemList(items);
        showAlert("Items sorted by stored date.");
    }

    @FXML
    public void onSortByExpirationDateButtonClick() {
        List<FoodItem> items = DataStore.getFoodItemList();
        SortController.sortByExpirationDate(items);
        setFoodItemList(items);
        showAlert("Items sorted by expiration date.");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sort Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}