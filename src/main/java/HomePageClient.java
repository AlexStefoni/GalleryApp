package main.java;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HomePageClient extends Application{

        public void start(Stage stage)
        {

            GridPane gp=new GridPane();
            gp.setAlignment(Pos.CENTER);
            gp.setPadding(new Insets(40,40,40,40));

            // Set the horizontal gap between columns
            gp.setHgap(10);

            // Set the vertical gap between rows
            gp.setVgap(10);


            ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
            columnOneConstraints.setHalignment(HPos.RIGHT);

            // columnTwoConstraints will be applied to all the nodes placed in column two.
            ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
            columnTwoConstrains.setHgrow(Priority.ALWAYS);

            gp.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        }
    // Main Method
    public static void main(String args[])
    {

        // launch the application
        launch(args);
    }
}
