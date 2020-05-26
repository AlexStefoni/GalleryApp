package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.java.AddArtwork;
import json.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomePageArtist extends Application {


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

    @Override
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
        Button btn5=new Button("Logout");


        leftControl.getChildren().add(btn1);
        leftControl.getChildren().add(btn2);

        leftControl.getChildren().add(btn5);

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

                AddArtwork ad=new AddArtwork();
                Stage st=new Stage();
                ad.start(st);

            }

        });


        btn5.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

                Stage stage=new Stage();
                Scene scene = new LoginScene(500, 350, stage);

               stage.setScene(scene);
                stage.show();
                primaryStage.close();

            }

        });

        BorderPane photoAlbum = new BorderPane();

        //file image processing for each border pane in Album
        ////////////////////////////////////////////////
        //photoAlbum.setTop();

        try {
            topStream = new FileInputStream("assets/pictures/1_kSQ64h9Muyqwoy9OZr26EA.jpeg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image top = new Image(topStream);
        ImageView topImview = new ImageView(top);
        topImview.setFitHeight(100);
        topImview.setFitWidth(100);

        //border structure of right split pane



        Button button1 = new Button();
        button1.setGraphic(topImview);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                Stage st=new Stage();
                try {
                    Scene scene2=new ArtworkFrame(800,500,st,top);
                    st.setScene(scene2);
                    st.show();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }



            }
        });

        GridPane topPane = new GridPane();
        topPane.getChildren().add(button1);

        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setBottom();

        try {
            bottomStream = new FileInputStream("assets/pictures/416275.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image bottom = new Image(bottomStream);
        ImageView bottomImview = new ImageView(bottom);
        bottomImview.setFitHeight(100);
        bottomImview.setFitWidth(100);



        Button button2 = new Button();
        button2.setGraphic(bottomImview);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                Stage st=new Stage();
                try {
                    Scene scene2=new ArtworkFrame(800,500,st,bottom);
                    st.setScene(scene2);
                    st.show();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }



            }
        });

        GridPane bottomPane = new GridPane();
        bottomPane.getChildren().add(button2);
        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setLeft();

        try {
            leftStream = new FileInputStream("assets/pictures/atmosphere.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image left = new Image(leftStream);
        ImageView leftImview = new ImageView(left);
        leftImview.setFitHeight(100);
        leftImview.setFitWidth(100);


        Button button3 = new Button();
        button3.setGraphic(leftImview);
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                Stage st=new Stage();
                try {
                    Scene scene2=new ArtworkFrame(800,500,st,left);
                    st.setScene(scene2);
                    st.show();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }



            }
        });

        GridPane leftPane = new GridPane();
        leftPane.getChildren().add(button3);
        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setRight();

        try {
            rightStream = new FileInputStream("assets/pictures/download.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image right = new Image(rightStream);
        ImageView rightImview = new ImageView(right);
        rightImview.setFitHeight(100);
        rightImview.setFitWidth(100);


        Button button4 = new Button();
        button4.setGraphic(rightImview);
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                Stage st=new Stage();
                try {
                    Scene scene2=new ArtworkFrame(800,500,st,right);
                    st.setScene(scene2);
                    st.show();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }



            }
        });

        GridPane rightPane = new GridPane();
        rightPane.getChildren().add(button4);

        ///////////////////////////////////////////////

        ////////////////////////////////////////////////
        //photoAlbum.setCenter();

        try {
            centerStream = new FileInputStream("assets/pictures/fi1023px-Gustav_Klimt_046.jpg");
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        Image center = new Image(centerStream);
        ImageView centerImview = new ImageView(center);
        centerImview.setFitHeight(100);
        centerImview.setFitWidth(100);


        Button button5 = new Button();
        button5.setGraphic(centerImview);
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                Stage st=new Stage();
                try {
                    Scene scene2=new ArtworkFrame(800,500,st,center);
                    st.setScene(scene2);
                    st.show();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }



            }
        });

        GridPane centerPane = new GridPane();
        centerPane.getChildren().add(button5);
        ///////////////////////////////////////////////


        //placing image panes within border panes
        photoAlbum.setTop(topPane);
        photoAlbum.setBottom(bottomPane);
        photoAlbum.setLeft(leftPane);
        photoAlbum.setRight(rightPane);
        photoAlbum.setCenter(centerPane);



        splitPane.getItems().addAll(leftControl, photoAlbum);

        Scene scene=new Scene(splitPane,800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("App");

        primaryStage.show();
    }
}


