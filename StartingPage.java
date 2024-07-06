/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023* Instructor: Prof. Brian King
 *
 * NName: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 02
 * Date: 4/14/23
 * Time: 10:55 AM
 *
 * Project: csci205_final_project
 * Package: KQ.controller
 * Class: StartingPage
 *
 * Description:
 *
 * *****************************************/
package KQ;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import KQ.MainPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartingPage {

    /** Resource Bundle from FXML scene builder */
    @FXML
    private ResourceBundle resources;

    /** The button that will be pressed to mute background sound */
    @FXML
    private Button muteBtn;

    /**  URL location from FXML scene builder*/
    @FXML
    private URL location;

    /** The background of the scene in the Opening page */
    @FXML
    private ImageView background;

    /** The image of the bison that will be controlled */
    @FXML
    private ImageView bison_gif;

    /** The start button that will be pressed to begin game */
    @FXML
    private Button startBtn;

    /** The title of the game being played*/
    @FXML
    private ImageView title;

    /** A getter method for the start button */
    public Button getStartBtn(){
        return startBtn;
    }

    private Clip clip;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'starting_page.fxml'.";
        assert bison_gif != null : "fx:id=\"bison_gif\" was not injected: check your FXML file 'starting_page.fxml'.";
        assert startBtn != null : "fx:id=\"startBtn\" was not injected: check your FXML file 'starting_page.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'starting_page.fxml'.";
        //assert muteBtn != null : "fx:id=\"muteBtn\" was not injected: check your FXML file 'starting_page.fxml'.";

    }

//    /**
//     * This was our attempt at the mute button for the music
//     */
//    @FXML
//    public void onMuteBtn()  {
//        Button muteBtn = new Button("Mute");
//        muteBtn.setOnAction(event -> {
//            if (clip != null && clip.isActive()) {
//                clip.stop();
//            }
//        });
//    }


    /**
     * When the user clicks on the start button, they are prompted to the Main Page
     * @throws IOException
     */
    @FXML
    public void onStartBtnNext() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPage.fxml"));
        Parent root = loader.load();

        MainPage mainPage = loader.getController();
        Scene scene = new Scene(root);
        mainPage.initialize(null, null);
        Stage stage = (Stage) startBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
