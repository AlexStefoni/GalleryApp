package main.java;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
public class FindArtwork extends Application {

    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("Find artwork");

        // create a button
        Button b = new Button("Show");

        // create a tile pane
        TilePane r = new TilePane();
        r.setAlignment(Pos.TOP_CENTER);
        r.setHgap(10);
        r.setVgap(10);


        // create a label
        Label l = new Label("Select the filter:");
        Label l1 = new Label("nothing selected");

        // string array
        String st[] = { "Price", "Material"};

        // create a choiceBox
        ChoiceBox c = new ChoiceBox(FXCollections.observableArrayList(st));

        // add a listener
        c.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                // set the text for the label to the selected item
                l1.setText(st[new_value.intValue()] + " selected");
            }
        });

        // add ChoiceBox
        r.getChildren().add(l);
        r.getChildren().add(c);
        r.getChildren().add(l1);
        r.getChildren().add(b);

        // create a scene
        Scene sc = new Scene(r, 800, 500);

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}