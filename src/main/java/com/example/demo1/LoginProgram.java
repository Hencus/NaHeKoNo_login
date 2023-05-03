package com.example.demo1;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginProgram extends Application {
    private static final String CORRECT_PASSWORD = "password123";
    private static final String CORRECT_USERNAME = "DUMMY";
    private Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Login Program");

        // create the logo image
        Image logoImage = new Image("file:logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setPreserveRatio(true);
        logoImageView.setFitHeight(300);
        logoImageView.setFitWidth(300);

        // create the NeptON code label and text field
        Label neptonCodeLabel = new Label("NeptON code:");
        TextField neptonCodeTextField = new TextField();
        neptonCodeTextField.setPromptText("Enter your identifier");

        // create the password label and password field
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // create the login button
        Button loginButton = new Button("Go");
        loginButton.setStyle("-fx-background-color: rgb(" + 49 + "," + 71 + ", " + 130 + "); -fx-text-fill: white;");

        // create the login message text
        Text loginMessageText = new Text();
        loginMessageText.setFill(Color.RED);
        loginMessageText.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        // create the grid pane and add the UI elements
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        gridPane.add(logoImageView, 0, 0, 2, 1);
        gridPane.add(neptonCodeLabel, 0, 1);
        gridPane.add(neptonCodeTextField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(loginButton, 1, 3);
        gridPane.add(loginMessageText, 1, 4);

        // set the action for the login button and password field
        passwordField.setOnAction(e -> {
            String identifier = neptonCodeTextField.getText();
            String password = passwordField.getText();
            if (identifier.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                // login successful, go to the welcome screen
                createWelcomeScene(identifier);
                loginMessageText.setText("");
                neptonCodeTextField.clear();
                passwordField.clear();
            } else if (identifier.equals(CORRECT_USERNAME)) {
                loginMessageText.setFill(Color.RED);
                loginMessageText.setText("Incorrect password");
            } else {
                loginMessageText.setFill(Color.RED);
                loginMessageText.setText("Unknown identifier");
            }
        });
        loginButton.setOnAction(e -> {
            String identifier = neptonCodeTextField.getText();
            String password = passwordField.getText();
            if (identifier.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                // login successful, go to the welcome screen
                createWelcomeScene(identifier);
                loginMessageText.setText("");
                neptonCodeTextField.clear();
                passwordField.clear();
            } else if (identifier.equals(CORRECT_USERNAME)) {
                loginMessageText.setFill(Color.RED);
                loginMessageText.setText("Incorrect password");
            } else {
                loginMessageText.setFill(Color.RED);
                loginMessageText.setText("Unknown identifier");
            }
        });

        Scene loginScene = new Scene(gridPane, 600, 400);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    // method to create the welcome screen
    private void createWelcomeScene(String identifier) {
        mainStage = new Stage();
        mainStage.setTitle("Welcome");

        Image logoImage = new Image("file:logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setPreserveRatio(true);
        logoImageView.setFitHeight(300);
        logoImageView.setFitWidth(300);

        // create the welcome message text
        Text welcomeMessageText = new Text("Welcome, " + identifier + "!");
        welcomeMessageText.setFill(Color.rgb(49,71,130));
        welcomeMessageText.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        //create logout button
        Button logoutButton = new Button("Log out");
        logoutButton.setStyle("-fx-background-color: rgb(" + 49 + "," + 71 + ", " + 130 + "); -fx-text-fill: white;");

        // create the grid pane and add the UI elements
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        gridPane.add(logoImageView, 0, 0, 2, 1);
        gridPane.add(welcomeMessageText, 0, 1);
        gridPane.add(logoutButton, 1, 0);

        logoutButton.setOnAction(e -> mainStage.close());

        Scene scene = new Scene(gridPane, 600, 400);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}