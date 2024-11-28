package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HomeController {
    @FXML
    private Button addItemButton;
    @FXML
    private Button displayItemButton;

    @FXML
    private Button searchItemButton;

    @FXML
    public void onAddItemClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project_check_1_expiration/AddItem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Add Food Item");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onDisplayItemClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project_check_1_expiration/DisplayItem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            DisplayItemController controller = fxmlLoader.getController();

            controller.setFoodItemList(DataStore.getFoodItemList());

            stage.setTitle("Display Food Items");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSearchItemClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project_check_1_expiration/SearchItem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Search for Item");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

