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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.java.AddArtwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomePageArtist extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws FileNotFoundException {

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.25f, 0.6f);

        VBox leftControl  = new VBox();
        VBox rightControl = new VBox();



        leftControl.setSpacing(20);
        Label label_title=new Label("Menu");
        leftControl.getChildren().add(label_title);



        rightControl.setStyle("-fx-background-color: #FFFFFF;");
        Label label=new Label("ArtGallery App");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        label.setTextFill(Color.web("#FF6347"));
        label.setAlignment(Pos.TOP_CENTER);




        Button btn1 =new Button("Add Artwork");
        Button btn2 =new Button("View orders");
        Button btn3 =new Button("See comments");
        Button btn4 =new Button("Modify details");


        leftControl.getChildren().add(btn1);
        leftControl.getChildren().add(btn2);
        leftControl.getChildren().add(btn3);
        leftControl.getChildren().add(btn4);

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

                AddArtwork ad=new AddArtwork();
                Stage st=new Stage();
                ad.start(st);

            }

        });

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
        Scene scene=new Scene(splitPane,800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("App");

        primaryStage.show();
    }
}


