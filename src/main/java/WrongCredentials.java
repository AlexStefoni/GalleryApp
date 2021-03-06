package main.java;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WrongCredentials {

    public static void display() {
        Stage stage = new Stage();

        //Block events to other windows
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Login error");
        stage.setMinWidth(300);
        stage.setMinHeight(150);

        Label label = new Label();
        label.setText("The username or password you entered is incorrect");

        Button closeButton = new Button("Try again");
        closeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display stage and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
