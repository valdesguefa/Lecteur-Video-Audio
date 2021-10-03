package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class debut extends Application implements Initializable {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent debut= FXMLLoader.load(getClass().getResource("Debut.fxml"));
        Scene nextscene=new Scene(debut);
        primaryStage.setScene(nextscene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
