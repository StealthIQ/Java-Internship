package com.example.breachbank.Views;

import com.example.breachbank.Controllers.Client.ClientController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

public class ViewFactory {
    // Client Views
    private AnchorPane dashboardView;

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Client/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dashboardView;
        }
        return null;
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader, "LoginWindow");
    }

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader, "ClientWindow");
    }

    private void createStage(FXMLLoader loader, String windowName) {
        try {
            // Create the scene
            Scene scene = new Scene(loader.load());

            // Set scene fill to transparent
            scene.setFill(Color.TRANSPARENT);

            // Create the stage
            Stage stage = new Stage();

            // Set stage style to transparent
            stage.initStyle(StageStyle.TRANSPARENT);

            // Set the scene to the stage
            stage.setScene(scene);

            // Icon for the app
            stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/Breach_bank_logo.png"))));

            // Make it unrezizable
            stage.setResizable(false);

            // Set the title for the stage
            stage.setTitle(windowName);

            // Show the stage
            stage.show();

            // Debug output
            System.out.println(windowName + " - Transparency settings applied successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(windowName + " - Error applying transparency settings");
        }
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
