package sample;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    MediaPlayer player;
    private DropShadow shadow1=new DropShadow(10, javafx.scene.paint.Color.BLUE);
    //ImageView play1= new ImageView(getClass().getResource("icons8_play_64px_5.png").toString());
    //ImageView pause1= new ImageView(getClass().getResource("icons8_pause_64px_5.png").toString());
    @FXML
    private Slider volslim;
    @FXML
    private Button RewindButton;
    @FXML
    private Slider slim;
    @FXML
    private Button ForwardButton;
    @FXML
    private MediaView mediaview;
    @FXML
    private Button PlayButton;

    @FXML
    void enter1(MouseEvent event) {
        ForwardButton.setEffect(shadow1);
    }

    @FXML
    void exited1(MouseEvent event) {
        ForwardButton.setEffect(null);
    }
//
@FXML
void enter2(MouseEvent event) {
    PlayButton.setEffect(shadow1);
}

    @FXML
    void exited2(MouseEvent event) {
        PlayButton.setEffect(null);
    }

    //
    //
    @FXML
    void enter3(MouseEvent event) {
        RewindButton.setEffect(shadow1);
    }

    @FXML
    void exited3(MouseEvent event) {
        RewindButton.setEffect(null);
    }
    @FXML
    void opensong(ActionEvent event) {
        try {
            FileChooser Chooser = new FileChooser();
            File file = Chooser.showOpenDialog(null);
            Media media = new Media(file.toURI().toURL().toString());

            player = new MediaPlayer(media);
            mediaview.setMediaPlayer(player);
            player.setOnReady(()->{
             slim.setMin(0);
             slim.setMax(player.getMedia().getDuration().toSeconds());
             //
                player.currentTimeProperty().addListener(new ChangeListener<Duration>(){
                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                        Duration d=player.getCurrentTime();
                        slim.setValue(d.toSeconds());
                    }
                });
                //

                //

                volslim.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        if(volslim.isValueChanging())
                        {
                            player.setVolume(volslim.getValue()/100.0);
                        }
                    }
                });
                //
                slim.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        if(slim.isPressed())
                        {
                            //double duree=slim.getValue();
                            player.seek(Duration.millis(slim.getValue()*1000));
                        }
                    }
                });
            });

            slim.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    player.seek(Duration.millis(slim.getValue()*1000));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void play(ActionEvent event) {

        try
        {
          MediaPlayer.Status status=player.getStatus();
          if(status==MediaPlayer.Status.PLAYING)
          {

             // PlayButton.setContentDisplay(ContentDisplay.TOP);
              player.pause();

              PlayButton.setGraphic(new ImageView(new Image(new FileInputStream("src/image/icons8_play_32px_1.png" ))));
              PlayButton.setContentDisplay(ContentDisplay.CENTER);

          }
          else
          {

              player.play();
             // PlayButton.setGraphic(play1);
              PlayButton.setGraphic(new ImageView(new Image(new FileInputStream("src/image/icons8_pause_32px.png" ))));
              PlayButton.setContentDisplay(ContentDisplay.CENTER);

          }
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void forward(ActionEvent event) {
    double t=player.getCurrentTime().toSeconds();
     t=t+60;
player.seek(new Duration(t*1000));
    }
    @FXML
    void rewind(ActionEvent event) {
        double z=player.getCurrentTime().toSeconds();
        z=z-60;
        player.seek(new Duration(z*1000));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
        {
            PlayButton.setGraphic(new ImageView(new Image(new FileInputStream("src/image/icons8_play_32px_1.png" ))));
            ForwardButton.setGraphic(new ImageView(new Image(new FileInputStream("src/image/icons8_fast_forward_32px.png" ))));
            RewindButton.setGraphic(new ImageView(new Image(new FileInputStream("src/image/icons8_rewind_32px.png" ))));
            player.setVolume(volslim.getValue()/100.0);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
