package main.java;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage primary) throws Exception {
        window = primary;
        window.setTitle("ArtGallery Login");

        //lambda expression for shutting down program
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //instance for Login Scene
        Scene scene = new LoginScene(500, 350);

        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = BoxExit.display("Close program alert", "Are you sure you want to exit?");
		/*
			code to be parsed after user
			sends command for closing program
			i.e. saving on db
		*/
        if (answer)
            window.close();
    }
}