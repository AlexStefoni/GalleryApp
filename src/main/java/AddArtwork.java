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

public class AddArtwork extends Application {

    // launch the application
    public void start(Stage stage)
    {

        try {


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

            // set title for the stage
            stage.setTitle("Choose a file");

            // create a File chooser
            FileChooser fil_chooser = new FileChooser();

            fil_chooser.setTitle("View Pictures");
            fil_chooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fil_chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );

            // create a Label
            Label label = new Label("No files selected");
            gp.add(label,1,0);

            // create a Button
            Button button = new Button("Choose File");
            gp.add(button, 1,1);



            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent e)
                        {

                            // get the file selected
                            File file = fil_chooser.showOpenDialog(stage);

                            if (file != null) {

                                label.setText(file.getAbsolutePath()
                                        + "  selected");

                            }

                        }
                    };

            button.setOnAction(event);




            Label userName = new Label("Enter details about the picture:");
            gp.add(userName, 1,2);



            Label artistLabel =new Label("Artist name:");
            gp.add(artistLabel,0,3);
            TextField artistName = new TextField();
            artistName.setMaxSize(300,200);
            gp.add(artistName, 1,3);




            Label titleLabel =new Label("Title:");
            gp.add(titleLabel,0,4);
            TextField title = new TextField();
            title.setMaxSize(300,200);
            gp.add(title,1,4);


            Label priceLabel=new Label("Price:");
            gp.add(priceLabel,0,5);
            TextField price = new TextField();
            price.setMaxSize(300,200);
            gp.add(price,1,5);



            Label materialLabel=new Label("Material:");
            gp.add(materialLabel,0,6);
            TextField material = new TextField();
            material.setMaxSize(300,200);
            gp.add(material,1,6);



            Label sizeLabel=new Label("Size:");
            gp.add(sizeLabel,0,7);
            TextField size = new TextField();
            size.setMaxSize(300,200);
            gp.add(size,1,7);


            Label stockLabel=new Label("Status:");
            gp.add(stockLabel,0,8);
            TextField stock = new TextField();
            stock.setMaxSize(300,200);
            gp.add(stock,1,8);


            Button save=new Button("Save");
            gp.add(save,1,9);



            Button clearAll = new Button("Clear All");
            clearAll.setOnAction((ActionEvent ev) -> {
                stock.clear();
                price.clear();
                material.clear();
                price.clear();
                artistName.clear();
                size.clear();
                title.clear();
            });


            gp.add(clearAll, 1,10,2,1);
            Scene scene = new Scene(gp, 800, 500);


            // set the scene
            stage.setScene(scene);

            stage.show();
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Main Method
    public static void main(String args[])
    {

        // launch the application
        launch(args);
    }
}
