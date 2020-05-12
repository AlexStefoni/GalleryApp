package main.java;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginAfterRegister extends Application {


    public void start(Stage primaryStage) {
        primaryStage.setTitle("ArtGallery Login");

        // Create the registration form grid pane
        GridPane gridPane = createLoginFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createLoginFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Welcome to ArtGallery!");
        headerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


        Label subheaderLabel = new Label("User Registration Successful! Please Login");
        subheaderLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        gridPane.add(subheaderLabel, 0,1,2,1);
        GridPane.setHalignment(subheaderLabel, HPos.CENTER);
        GridPane.setMargin(subheaderLabel, new Insets(10, 0,10,0));

        Label userName = new Label("Username:");
        gridPane.add(userName, 0, 2);

        TextField userBox = new TextField();
        gridPane.add(userBox, 1, 2);

        //creating Password block & pos
        Label pass = new Label("Password:");
        gridPane.add(pass, 0, 3);

        PasswordField passBox = new PasswordField();
        gridPane.add(passBox, 1, 3);

        Button btn2 = new Button("Sign in");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn2.getChildren().add(btn2);
        gridPane.add(hbBtn2, 1, 4);

        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 5);

    }
}
