package main.java;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class ArtworkFrame extends Scene {

    public ArtworkFrame(double width, double height, Stage stage, Image image) throws FileNotFoundException {
        super(new GridPane(), width, height);

        GridPane grid = (GridPane) this.getRoot();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);



        ImageView imageView = new ImageView(image);
        imageView.setX(10);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(260);
        imageView.setFitWidth(260);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        Button order=new Button("Order");

        VBox vb=new VBox();
        vb.getChildren().add(imageView);
        vb.getChildren().add(order);
        vb.setSpacing(10);
        grid.getChildren().add(vb);
        this.setRoot(grid);
    }


}
