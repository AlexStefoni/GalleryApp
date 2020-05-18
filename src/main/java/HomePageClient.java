package main.java;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomePageClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws FileNotFoundException {

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.2f, 0.6f);

        VBox leftControl  = new VBox(new Label("Menu"));
        VBox rightControl = new VBox(new Label("ArtGallery App"));
        leftControl.setSpacing(20);


        Button btn1 =new Button("Find Artworks");
        leftControl.getChildren().add(btn1);

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

             FindArtwork fa=new FindArtwork();
                Stage stage = new Stage();
                fa.start(stage);


            }

        });

        Button btn2 =new Button("History");
        leftControl.getChildren().add(btn2);


        FileInputStream inputstream = null;
        inputstream = new FileInputStream("C:\\Users\\user\\Desktop\\unnamed.jpg");
        Image image = new Image(inputstream);
        ImageView imageView = new ImageView(image);
        imageView.setX(10);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        rightControl.setAlignment(Pos.CENTER);
        rightControl.getChildren().add(imageView);


        splitPane.getItems().addAll(leftControl, rightControl);

        Scene scene = new Scene(splitPane,800,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ArtGallery App");

        primaryStage.show();
    }
}
