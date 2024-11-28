package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class SearchItemController {

        @FXML
        private Button searchButton;
        @FXML
        private Button removeButton;

        @FXML
        private TextField searchNameField;
        @FXML
        private TextField searchCategoryField;
        @FXML
        private DatePicker searchStoredDatePicker;
        @FXML
        private DatePicker searchExpirationDatePicker;
        @FXML
        private Label resultLabel;
        private int foundIndex = -1;

        @FXML
        public void onSearchButtonClick() {
            String name = searchNameField.getText();
            List<FoodItem> foodItemList = DataStore.getFoodItemList();

            if (foodItemList.isEmpty()) {
                resultLabel.setText("No items available to search. Add some items first!");
                foundIndex = -1;
            } else {
                boolean found = false;
                for (int i = 0; i < foodItemList.size(); i++) {
                    FoodItem item = foodItemList.get(i);
                    if (item.getName().equalsIgnoreCase(name)) {
                        resultLabel.setText("Item found: " + item.getName() + " at index: " + i);
                        foundIndex = i;
                        found = true;
                        removeButton.setDisable(false);
                        break;
                    }
                }

                if (!found) {
                    resultLabel.setText("Item not found.");
                    foundIndex = -1;
                }
            }
        }
    @FXML
    public void onRemoveButtonClick() {
        if (foundIndex != -1) {
            List<FoodItem> foodItemList = DataStore.getFoodItemList();
            FoodItem itemToRemove = foodItemList.get(foundIndex);
            foodItemList.remove(foundIndex);

            DataStore.saveToCSV();
            foundIndex = -1;

            resultLabel.setText("Item removed: " + itemToRemove.getName());
        } else {
            resultLabel.setText("No item selected for removal. Please search for an item first.");
        }
    }
}

