package main.java;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import json.JsonUtils;

public class LoginAfterRegister extends Scene {

    public LoginAfterRegister(double width, double height, Stage window) {

        super(new GridPane(), width, height);

        window.setTitle("ArtGallery Login");

        // Create the registration form grid pane
        GridPane gridPane = (GridPane) this.getRoot();

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
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);


        // Add UI controls to the registration form grid pane
        Label headerLabel = new Label("Welcome to ArtGallery!");
        headerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));


        Label subheaderLabel = new Label("Registration Successful! Please Login");
        subheaderLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        subheaderLabel.setTextFill(Color.web("#008000"));

        gridPane.add(subheaderLabel, 0, 1, 2, 1);
        GridPane.setHalignment(subheaderLabel, HPos.CENTER);
        GridPane.setMargin(subheaderLabel, new Insets(10, 0, 10, 0));

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

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {

                String username = userBox.getText();
                String password = passBox.getText();
                if (JsonUtils.credentialTest(username, password) == false)
                {
                    WrongCredentials wr=new WrongCredentials();
                    wr.display();

                }
                else
                {
                    if(JsonUtils.ifArtist(username,password)==true){
                        HomePageArtist hma=new HomePageArtist();
                        Stage stage1=new Stage();
                        hma.start(stage1);
                    }
                    else {
                        HomePageClient hc=new HomePageClient();
                        Stage stage1=new Stage();
                        hc.start(stage1);

                    }

                }
                window.close();

            }

        });

        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 5);

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {

                RegisterScene rs = new RegisterScene();
                Stage stage = new Stage();
                rs.start(stage);

            }

        });


        this.setRoot(gridPane);


    }
}
