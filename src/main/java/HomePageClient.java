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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomePageClient extends Application {


    //
    private FileInputStream topStream;
    //
    private FileInputStream bottomStream;
    //
    private FileInputStream leftStream;
    //
    private FileInputStream rightStream;
    //
    private FileInputStream centerStream;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws FileNotFoundException {

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.2f, 0.6f);

        VBox leftControl  = new VBox(new Label("Menu"));
        leftControl.setSpacing(20);


        //setting right split panel ALBUM
        //right_split
        BorderPane photoAlbum = new BorderPane();

        //file image processing for each border pane in Album
        ////////////////////////////////////////////////
        //photoAlbum.setTop();

        try {
            topStream = new FileInputStream("C:\\Users\\user\\Desktop\\GalApp\\GalleryApp\\assets\\pictures\\unnamed.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image top = new Image(topStream);
        ImageView topImview = new ImageView(top);
        topImview.setFitHeight(100);
       topImview.setFitWidth(100);

        //border structure of right split pane
        GridPane topPane = new GridPane();
        topPane.getChildren().add(topImview);
        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setBottom();

        try {
            bottomStream = new FileInputStream("C:\\Users\\user\\Desktop\\GalApp\\GalleryApp\\assets\\pictures\\unnamed.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image bottom = new Image(bottomStream);
        ImageView bottomImview = new ImageView(bottom);
        bottomImview.setFitHeight(100);
       bottomImview.setFitWidth(100);

        GridPane bottomPane = new GridPane();
        bottomPane.getChildren().add(bottomImview);
        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setLeft();

        try {
            leftStream = new FileInputStream("C:\\Users\\user\\Desktop\\GalApp\\GalleryApp\\assets\\pictures\\unnamed.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image left = new Image(leftStream);
        ImageView leftImview = new ImageView(left);
        leftImview.setFitHeight(100);
        leftImview.setFitWidth(100);

        GridPane leftPane = new GridPane();
        leftPane.getChildren().add(leftImview);
        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setRight();

        try {
            rightStream = new FileInputStream("C:\\Users\\user\\Desktop\\GalApp\\GalleryApp\\assets\\pictures\\unnamed.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image right = new Image(rightStream);
        ImageView rightImview = new ImageView(right);
        rightImview.setFitHeight(100);
        rightImview.setFitWidth(100);

        GridPane rightPane = new GridPane();
        rightPane.getChildren().add(rightImview);

        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setCenter();

        try {
            centerStream = new FileInputStream("C:\\Users\\user\\Desktop\\GalApp\\GalleryApp\\assets\\pictures\\unnamed.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image center = new Image(centerStream);
        ImageView centerImview = new ImageView(center);
       centerImview.setFitHeight(100);
        centerImview.setFitWidth(100);

        GridPane centerPane = new GridPane();
        centerPane.getChildren().add(centerImview);
        ///////////////////////////////////////////////


        //placing image panes within border panes
        photoAlbum.setTop(topPane);
        photoAlbum.setBottom(bottomPane);
        photoAlbum.setLeft(leftPane);
        photoAlbum.setRight(rightPane);
        photoAlbum.setCenter(centerPane);




        //setting divider line between split panes
        splitPane.setDividerPositions(0.25);








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

        Button btn3 =new Button("Log out");
        leftControl.getChildren().add(btn3);


        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

                Stage stage=new Stage();
                Scene scene = new LoginScene(500, 350, stage);

                stage.setScene(scene);
                stage.show();
                primaryStage.close();

            }

        });












        splitPane.getItems().addAll(leftControl, photoAlbum);

        Scene scene = new Scene(splitPane,800,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ArtGallery App");

        primaryStage.show();
    }
}
