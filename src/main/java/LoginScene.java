package main.java;


import NewSuff.UserHandle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import json.JsonUtils;

import java.io.FileNotFoundException;


public class LoginScene extends Scene {

    public LoginScene(double width, double height, Stage window) {
        super(new GridPane(), width, height);

        GridPane grid = (GridPane) this.getRoot();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //simple Title label & pos
        Text scenetitle = new Text("Welcome to ArtGallery!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //creating Username block & pos
        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);

        TextField userBox = new TextField();
        grid.add(userBox, 1, 1);

        //creating Password block & pos
        Label pass = new Label("Password:");
        grid.add(pass, 0, 2);

        PasswordField passBox = new PasswordField();
        grid.add(passBox, 1, 2);

        Button btn2 = new Button("Sign in");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 1, 4);

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {

                String username = userBox.getText();
                String password = passBox.getText();

                UserHandle account = new UserHandle();


                if (account.fileExists()==false) {
                    NoUsersYet noU = new NoUsersYet();
                    noU.display();
                }
                else{
                    if (account.CredentialTest(username, password) == false) {
                        WrongCredentials wr = new WrongCredentials();
                        wr.display();

                    } else {
                        account.setStatus(username);
                        if (account.ifArtist(username, password) == true) {
                            HomePageArtist hma = new HomePageArtist();
                            Stage stage1 = new Stage();
                            try {
                                hma.start(stage1);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            HomePageClient hc = new HomePageClient();
                            Stage stage1 = new Stage();
                            try {
                                hc.start(stage1);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        }


                        window.close();
                    }
                }
                }


        });

        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);


        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e){

                RegisterScene rs=new RegisterScene();
                Stage stage = new Stage();
                rs.start(stage);
                window.close();

            }

        });

        this.setRoot(grid);
    }


}
