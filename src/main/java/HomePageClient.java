package main.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePageClient extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.2f, 0.6f);

        VBox leftControl  = new VBox(new Label("Meniu"));
        VBox rightControl = new VBox(new Label("ArtGallery App"));


        Button btn1 =new Button("Find Artworks");

        leftControl.getChildren().add(btn1);

        splitPane.getItems().addAll(leftControl, rightControl);

        Scene scene = new Scene(splitPane,800,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ArtGallery App");

        primaryStage.show();
    }
}
