package main.java;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import json.User;
import main.java.MainLogin;

public class RegisterScene extends Application {


    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration in ArtGallery");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane

        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);


        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        Label userLabel = new Label("Username : "); //changed from json.User->Username
        gridPane.add(userLabel, 0,2);


        // Add Name Text Field
        TextField userField = new TextField();
        userField.setPrefHeight(40);
        gridPane.add(userField, 1,2);


        // Add Email Label
        Label addressLabel = new Label("Address : ");
        gridPane.add(addressLabel, 0, 3);

        // Add Email Text Field
        TextField addressField = new TextField();
        addressField.setPrefHeight(40);
        gridPane.add(addressField, 1, 3);


        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 4);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 4);


        Label phoneLabel = new Label("Phone : ");
        gridPane.add(phoneLabel, 0, 5);

        // Add Phone Field
        TextField phoneField = new TextField();
        phoneField.setPrefHeight(40);
        gridPane.add(phoneField, 1, 5);


        CheckBox checkBox1 = new CheckBox("I want to be Artist");
        HBox hbox = new HBox(checkBox1);
        Scene scene = new Scene(hbox, 200, 100);


        checkBox1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                boolean isChecked = checkBox1.isSelected();

            }

        });




        gridPane.add(checkBox1,1,6 );


        // Add Submit Button
        Button submitButton = new Button("Register");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


//Adding a Label
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 7);
        GridPane.setColumnSpan(label, 2);
        gridPane.getChildren().add(label);

//Setting an action for the Submit button
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if ((nameField.getText() != null && !nameField.getText().isEmpty() && addressField.getText() != null && !addressField.getText().isEmpty()&& passwordField.getText() != null && !passwordField.getText().isEmpty() && phoneField.getText() != null && !phoneField.getText().isEmpty() )) {
                    {
                        submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            public void handle(MouseEvent e){

                                LoginAfterRegister rs=new LoginAfterRegister();
                                Stage stage = new Stage();
                                rs.start(stage);

                                String name=nameField.getText();
                                String address=addressField.getText();
                                String phone=phoneField.getText();
                                String password=passwordField.getText();
                                String user=userField.getText();
                                boolean isSelected = checkBox1.isSelected();
                                //writing the user assets
                                //replace User(,,false,,); with the value from the checkbox[SOLVED]
                                //also phone ? i don/t remeber any phone .
                                User user_register=new User(user,password,isSelected,name,address);
                                json.JsonUtils.registerNewUser(user_register);
                                primaryStage.close();




                            }

                        });
                    }
                } else {
                    label.setText("There are still empty fields");
                }
            }
        });





        // Create a scene with registration form grid pane as the root node
        Scene scene1 = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene1);
        primaryStage.show();

    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

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
}