package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    private DropShadow shadow=new DropShadow(10, Color.GOLD);
    //private DropShadow shadow2=new DropShadow(10, Color.GOLD);
    @FXML
    private Button continu;

    @FXML
    private Button ferme;



    @FXML
    void continuer(ActionEvent event) throws IOException {
        Parent debut= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene nextscene=new Scene(debut);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(nextscene);
        stage.setResizable(false);
        stage.show();
    }
        @FXML
    void close(ActionEvent event) {

        ((Node)event.getSource()).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
@FXML
    public void entered(MouseEvent mouseEvent) {
        continu.setEffect(shadow);
    }

    @FXML
    public void exited(MouseEvent mouseEvent) {
        continu.setEffect(null);
    }

    @FXML
    public void fermeentered(MouseEvent mouseEvent) { ferme.setEffect(shadow);
    }

    @FXML
    public void fermeexited(MouseEvent mouseEvent) { ferme.setEffect(null);
    }
}
